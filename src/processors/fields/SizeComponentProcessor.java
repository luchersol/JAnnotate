package src.processors.fields;

import java.lang.reflect.Field;

import javax.swing.JComponent;

import src.annotations.fields.SizeComponent;

public class SizeComponentProcessor {

    public static void process(Field field, Object object) {
        if (field.isAnnotationPresent(SizeComponent.class)) {
            SizeComponent sizeAnnotation = field.getAnnotation(SizeComponent.class);
            field.setAccessible(true);
            try {
                Object value = field.get(object);
                if (value instanceof JComponent) {
                    JComponent component = (JComponent) value;
                    component.setPreferredSize(new java.awt.Dimension(sizeAnnotation.width(), sizeAnnotation.heigth()));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

}
