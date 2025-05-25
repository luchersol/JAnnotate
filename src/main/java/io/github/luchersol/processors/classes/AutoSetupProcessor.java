package io.github.luchersol.processors.classes;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import javax.swing.JComponent;

import io.github.luchersol.annotations.classes.AutoInstantiateFields;
import io.github.luchersol.annotations.classes.AutoSetup;
import io.github.luchersol.annotations.classes.layoutManager.UseBorderLayout;
import io.github.luchersol.annotations.classes.layoutManager.UseGridBagLayout;
import io.github.luchersol.annotations.classes.layoutManager.UseLayoutManager;
import io.github.luchersol.annotations.fields.AddOrder;
import io.github.luchersol.annotations.fields.BorderPosition;
import io.github.luchersol.annotations.fields.GridBagConfig;
import io.github.luchersol.annotations.mixed.fields_classes.IsVisible;
import io.github.luchersol.annotations.mixed.fields_classes.SetDefaultClose;
import io.github.luchersol.annotations.mixed.fields_classes.SetSize;
import io.github.luchersol.annotations.mixed.fields_classes.SetTitle;
import io.github.luchersol.common.abstractClasses.AbstractClassProcessor;
import io.github.luchersol.common.annotations.InsetsAnnotation;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.common.annotations.PriorityAnnotation;
import io.github.luchersol.common.exceptions.LogException;
import io.github.luchersol.common.utils.AnnotationMocks;
import io.github.luchersol.processors.mixed.fields_classes.IsVisibleProcessor;
import io.github.luchersol.processors.mixed.fields_classes.SetDefaultCloseProcessor;
import io.github.luchersol.processors.mixed.fields_classes.SetSizeProcessor;
import io.github.luchersol.processors.mixed.fields_classes.SetTitleProcessor;

@JProcessor
@PriorityAnnotation
public class AutoSetupProcessor extends AbstractClassProcessor<AutoSetup> {

    @Override
    public void process(Class<?> clazz, Object object, AutoSetup annotation) throws LogException {
        processAutoInstatiate(clazz, object, annotation);
        processAutoAddComponents(clazz, object, annotation);
        processIsVisible(clazz, object, annotation);
        processSetSize(clazz, object, annotation);
        processSetTitle(clazz, object, annotation);
        processSetDefaultClose(clazz, object, annotation);
    }

    public void processAutoInstatiate(Class<?> clazz, Object object, AutoSetup annotation) throws LogException {
        AutoInstantiateFieldsProcessor processor = new AutoInstantiateFieldsProcessor();
        AutoInstantiateFields innerAnnotation = AnnotationMocks
                .autoInstantiateFields(annotation.recursiveAutoInstatiate());
        processor.process(clazz, object, innerAnnotation);
    }

    public void processIsVisible(Class<?> clazz, Object object, AutoSetup annotation) throws LogException {
        IsVisibleProcessor processor = new IsVisibleProcessor();
        IsVisible innerAnnotation = AnnotationMocks.isVisible(annotation.isVisible());
        processor.process(clazz, object, innerAnnotation);
    }

    public void processAutoAddComponents(Class<?> clazz, Object object, AutoSetup annotation)
            throws LogException {
        List<Field> sortedFields = Arrays.stream(clazz.getDeclaredFields())
                .filter((Field f) -> {
                    try {
                        f.setAccessible(true);
                        return f.get(object) instanceof Component;
                    } catch (IllegalArgumentException | IllegalAccessException e) {
                        e.printStackTrace();
                        return false;
                    }
                })
                .sorted(Comparator.comparingInt((Field field) -> {
                    AddOrder innerAnnotation = field.getAnnotation(AddOrder.class);
                    return innerAnnotation != null ? innerAnnotation.value() : Integer.MAX_VALUE;
                }))
                .toList();

        boolean useGridBagLayout = annotation.layout().getClass() == UseGridBagLayout.class;
        boolean useBorderLayout = annotation.layout().getClass() == UseBorderLayout.class;
        if (annotation.layout().getClass() == UseLayoutManager.class) {
            UseLayoutManager useLayoutManager = clazz.getAnnotation(UseLayoutManager.class);
            Class<? extends LayoutManager> ex = useLayoutManager.value();
            useGridBagLayout |= ex == GridBagLayout.class;
            useBorderLayout |= ex == BorderLayout.class;
        }
        if (!(useGridBagLayout || useBorderLayout) && object instanceof JComponent) {
            JComponent jComponent = (JComponent) object;
            LayoutManager layoutManager = jComponent.getLayout();
            useGridBagLayout = layoutManager.getClass() == GridBagLayout.class;
            useBorderLayout = layoutManager.getClass() == BorderLayout.class;
        }
        for (Field field : sortedFields) {
            if (useGridBagLayout) {
                GridBagConstraints gridBagConstraints = new GridBagConstraints();
                processAddGridBagLayout(clazz, object, field, gridBagConstraints);
            } else if (useBorderLayout) {
                processAddBorderLayout(clazz, object, field);
            } else {
                processAddDefault(clazz, object, field);
            }
        }

    }

    public static void processAddBorderLayout(Class<?> clazz, Object object, Field field) {
        try {
            field.setAccessible(true);
            Object value = field.get(object);
            if (value == null || !Component.class.isAssignableFrom(clazz))
                return;

            if (field.isAnnotationPresent(BorderPosition.class)) {
                BorderPosition borderPosition = field.getAnnotation(BorderPosition.class);
                Method method = clazz.getMethod("add", Component.class, Object.class);
                method.setAccessible(true);
                method.invoke(object, value, borderPosition.value());
            } else {
                Method method = clazz.getMethod("add", Component.class);
                method.setAccessible(true);
                method.invoke(object, value);
            }

        } catch (Exception e) {
            throw new RuntimeException("Error al procesar el campo: " + field.getName(), e);
        }
    }

    public static void processAddGridBagLayout(Class<?> clazz, Object object, Field field,
            GridBagConstraints gridBagConstraints) {
        try {
            field.setAccessible(true);
            Object value = field.get(object);
            if (value == null || !Component.class.isAssignableFrom(clazz))
                return;

            if (field.isAnnotationPresent(GridBagConfig.class)) {
                GridBagConfig gridBagConfig = field.getAnnotation(GridBagConfig.class);
                trapass(gridBagConstraints, gridBagConfig);
                Method method = clazz.getMethod("add", Component.class, Object.class);
                method.setAccessible(true);
                method.invoke(object, value, gridBagConstraints);
            } else {
                Method method = clazz.getMethod("add", Component.class);
                method.setAccessible(true);
                method.invoke(object, value);
            }

        } catch (Exception e) {
            throw new RuntimeException("Error al procesar el campo: " + field.getName(), e);
        }
    }

    private static void trapass(GridBagConstraints gridBagConstraints, GridBagConfig gridBagConfig) {
        gridBagConstraints.anchor = gridBagConfig.anchor();
        gridBagConstraints.fill = gridBagConfig.fill();
        gridBagConstraints.gridheight = gridBagConfig.gridheight();
        gridBagConstraints.gridwidth = gridBagConfig.gridwidth();
        gridBagConstraints.gridx = gridBagConfig.gridx();
        gridBagConstraints.gridy = gridBagConfig.gridy();
        InsetsAnnotation insetsAnnotation = gridBagConfig.insets();
        gridBagConstraints.insets = new Insets(insetsAnnotation.top(),
                insetsAnnotation.left(),
                insetsAnnotation.bottom(),
                insetsAnnotation.right());
        gridBagConstraints.ipadx = gridBagConfig.ipadx();
        gridBagConstraints.ipady = gridBagConfig.ipady();
        gridBagConstraints.weightx = gridBagConfig.weightx();
        gridBagConstraints.weighty = gridBagConfig.weighty();
    }

    public static void processAddDefault(Class<?> clazz, Object object, Field field) {
        try {
            field.setAccessible(true);
            Object value = field.get(object);

            if (value == null || !Component.class.isAssignableFrom(value.getClass()))
                return;

            Method method = clazz.getMethod("add", Component.class);
            method.setAccessible(true);
            method.invoke(object, value);
        } catch (Exception e) {
            throw new RuntimeException("Error al procesar el campo: " + field.getName(), e);
        }
    }

    public void processSetSize(Class<?> clazz, Object object, AutoSetup annotation) throws LogException {
        SetSizeProcessor processor = new SetSizeProcessor();
        SetSize innerAnnotation = annotation.size();
        processor.process(clazz, object, innerAnnotation);
    }

    public void processSetTitle(Class<?> clazz, Object object, AutoSetup annotation) throws LogException {
        SetTitleProcessor processor = new SetTitleProcessor();
        SetTitle innerAnnotation = AnnotationMocks.setTitle(annotation.title());
        processor.process(clazz, object, innerAnnotation);
    }

    public void processSetDefaultClose(Class<?> clazz, Object object, AutoSetup annotation) throws LogException {
        SetDefaultCloseProcessor processor = new SetDefaultCloseProcessor();
        SetDefaultClose innerAnnotation = AnnotationMocks.setDefaultClose(annotation.defaultClose());
        processor.process(clazz, object, innerAnnotation);
    }

}
