package com.jannotate.processors.fields;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.swing.AbstractButton;

import com.jannotate.annotations.fields.ActionComponent;

public class ActionComponentProcessor implements FieldProcessor {
    
    public void process(Field field, Object object) {
        if (field.isAnnotationPresent(ActionComponent.class)) {
            ActionComponent actionAnnotation = field.getAnnotation(ActionComponent.class);
            processActionComponent(field, object, actionAnnotation);
        }
        
    }

    public static void processActionComponent(Field field, Object object, ActionComponent actionAnnotation ) {
        field.setAccessible(true);
        try {
            Object value = field.get(object);
            if (value instanceof AbstractButton) {
                AbstractButton component = (AbstractButton) value;

                // Obtén el nombre del método desde la anotación
                String methodName = actionAnnotation.method();
                Method method = object.getClass().getDeclaredMethod(methodName);
                method.setAccessible(true);
                
                // Agrega un ActionListener que invoca el método
                component.addActionListener(e -> {
                        try {
                            method.invoke(object);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    
                });
            }
        } catch (IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
