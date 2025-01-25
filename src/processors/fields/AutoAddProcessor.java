package src.processors.fields;

import java.awt.Container;
import java.lang.reflect.Field;

import javax.swing.JComponent;

import src.annotations.fields.AutoAdd;

public class AutoAddProcessor {
    
    public static void process(Container container, Field field) {
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
