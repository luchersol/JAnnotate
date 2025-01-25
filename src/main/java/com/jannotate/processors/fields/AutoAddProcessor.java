package com.jannotate.processors.fields;

import java.awt.Container;
import java.lang.reflect.Field;

import javax.swing.JComponent;

import com.jannotate.annotations.fields.AutoAdd;
import com.jannotate.common.FieldProcessor;

public class AutoAddProcessor implements FieldProcessor {
    
    public void process(Field field, Object object) {
        Container container = (Container) object;
        if (field.isAnnotationPresent(AutoAdd.class)) {
            field.setAccessible(true);
            try {
                Object value = field.get(container);
                if (value instanceof JComponent) {
                    container.add((JComponent) value);
                } else {
                    throw new IllegalArgumentException("Field annotated with @AutoAdd must be a JComponent.");
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        
    }
}
