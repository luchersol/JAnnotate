package com.jannotate.processors.fields;

import java.awt.Color;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.jannotate.annotations.fields.TextComponent;

public class TextComponentProcessor implements FieldProcessor {
    
    public void process(Field field, Object object) {
        if (field.isAnnotationPresent(TextComponent.class)) {
            TextComponent textAnnotation = field.getAnnotation(TextComponent.class);
            field.setAccessible(true);
            try {
                Object value = field.get(object);
                 if (value != null) {
                // Obtenemos la clase del objeto del campo
                Class<?> clazz = value.getClass();

                Method setTextMethod = null;
                try {
                    setTextMethod = clazz.getMethod("setText", String.class);
                } catch (NoSuchMethodException e) {
                    System.out.println("El campo no tiene un método 'setText(String)'");
                }

                Method setForegroundMethod = null;
                try {
                    setForegroundMethod = clazz.getMethod("setForeground", Color.class);
                } catch (NoSuchMethodException e) {
                    System.out.println("El campo no tiene un método 'setForeground(Color)'");
                }

                if (setTextMethod != null) {
                    setTextMethod.invoke(value, textAnnotation.text());
                }

                if (setForegroundMethod != null) {
                    Color color = textAnnotation.color().getColor();
                    if(color == null) {
                        color = new Color(textAnnotation.red(), textAnnotation.green(), textAnnotation.blue());
                    }
                    setForegroundMethod.invoke(value, color);
                }
            }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
    
}
