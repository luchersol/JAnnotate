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

import com.jannotate.annotations.classes.AutoAddComponents;
import com.jannotate.annotations.classes.layoutManager.UseBorderLayout;
import com.jannotate.annotations.classes.layoutManager.UseGridBagLayout;
import com.jannotate.annotations.classes.layoutManager.UseLayoutManager;
import com.jannotate.annotations.fields.AddOrder;
import com.jannotate.annotations.fields.BorderPosition;
import com.jannotate.annotations.fields.GridBagConfig;
import com.jannotate.common.abstractClasses.AbstractClassProcessor;
import com.jannotate.common.annotations.InsetsAnnotation;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.common.exceptions.LogException;

@JProcessor
public class AutoAddComponentsProcessor extends AbstractClassProcessor<AutoAddComponents> {

    @Override
    public void process(Class<?> clazz, Object object, AutoAddComponents annotation) throws LogException {
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

}
