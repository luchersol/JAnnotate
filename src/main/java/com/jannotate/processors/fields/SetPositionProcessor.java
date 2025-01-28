package com.jannotate.processors.fields;

import java.lang.reflect.Field;

import javax.swing.JComponent;

import com.jannotate.annotations.fields.SetPosition;
import com.jannotate.common.FieldProcessorInterface;
import com.jannotate.common.JProcessor;

@JProcessor
public class SetPositionProcessor implements FieldProcessorInterface {
    
    public void process(Field field, Object object) {
        if (field.isAnnotationPresent(SetPosition.class)) {
            SetPosition positionAnnotation = field.getAnnotation(SetPosition.class);
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
