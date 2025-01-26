package com.jannotate.processors.fields;

import java.lang.reflect.Field;

import javax.swing.JComponent;

import com.jannotate.annotations.fields.SetSize;
import com.jannotate.common.FieldProcessor;

public class SetSizeProcessor implements FieldProcessor {

    public void process(Field field, Object object) {
        if (field.isAnnotationPresent(SetSize.class)) {
            SetSize sizeAnnotation = field.getAnnotation(SetSize.class);
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
