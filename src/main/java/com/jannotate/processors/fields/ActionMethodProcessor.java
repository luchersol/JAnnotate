package com.jannotate.processors.fields;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.swing.AbstractButton;

import com.jannotate.annotations.fields.ActionMethod;
import com.jannotate.common.FieldProcessor;

public class ActionMethodProcessor implements FieldProcessor {
    
    public void process(Field field, Object object) {
        if (field.isAnnotationPresent(ActionMethod.class)) {
            ActionMethod actionAnnotation = field.getAnnotation(ActionMethod.class);
            processActionComponent(field, object, actionAnnotation);
        }
        
    }

    public static void processActionComponent(Field field, Object object, ActionMethod actionAnnotation ) {
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
