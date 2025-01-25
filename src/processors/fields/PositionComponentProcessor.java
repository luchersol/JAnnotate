package src.processors.fields;

import java.lang.reflect.Field;

import javax.swing.JComponent;

import src.annotations.fields.PositionComponent;

public class PositionComponentProcessor {
    
    public static void process(Field field, Object object) {
        if (field.isAnnotationPresent(PositionComponent.class)) {
            PositionComponent positionAnnotation = field.getAnnotation(PositionComponent.class);
            field.setAccessible(true);
            try {
                Object value = field.get(object);
                if (value instanceof JComponent) {
                    JComponent component = (JComponent) value;
                    component.setBounds(positionAnnotation.x(), positionAnnotation.y(), component.getWidth(), component.getHeight());
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

}
