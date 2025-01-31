package com.jannotate.processors.classes;

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

import com.jannotate.annotations.classes.AutoInstantiateFields;
import com.jannotate.annotations.classes.layoutManager.UseBorderLayout;
import com.jannotate.annotations.classes.layoutManager.UseGridBagLayout;
import com.jannotate.annotations.classes.layoutManager.UseLayoutManager;
import com.jannotate.annotations.fields.AddOrder;
import com.jannotate.annotations.fields.BorderPosition;
import com.jannotate.annotations.fields.GridBagConfig;
import com.jannotate.common.annotations.InsetsAnnotation;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.common.interfaces.ClassProcessorInterface;

@JProcessor
public class AutoAddComponentsProcessor implements ClassProcessorInterface {

    @Override
    public void process(Class<?> clazz, Object object) {
        if (clazz.isAnnotationPresent(AutoInstantiateFields.class)) {
            processAdd(clazz, object);
        }
    }

    public void processAdd(Class<?> clazz, Object object) {
        List<Field> sortedFields = Arrays.stream(clazz.getDeclaredFields())
                .sorted(Comparator.comparingInt((Field field) -> {
                    AddOrder annotation = field.getAnnotation(AddOrder.class);
                    return annotation != null ? annotation.value() : Integer.MAX_VALUE;
                }))
                .toList();

        boolean useGridBagLayout = clazz.isAnnotationPresent(UseGridBagLayout.class);
        boolean useBorderLayout = clazz.isAnnotationPresent(UseBorderLayout.class);
        if (clazz.isAnnotationPresent(UseLayoutManager.class)) {
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
            field.setAccessible(true); // Asegurar acceso al campo
            Object value = field.get(object);

            if (value == null || !Component.class.isAssignableFrom(clazz))
                return;

            Method method = clazz.getMethod("add", Component.class);
            method.setAccessible(true); // Asegurar acceso al método
            method.invoke(object, value);

        } catch (Exception e) {
            throw new RuntimeException("Error al procesar el campo: " + field.getName(), e);
        }
    }

}