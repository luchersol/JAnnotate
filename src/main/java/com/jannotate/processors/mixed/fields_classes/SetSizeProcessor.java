package com.jannotate.processors.mixed.fields_classes;

import java.awt.Component;
import java.lang.reflect.Field;

import com.jannotate.annotations.mixed.fields_classes.SetSize;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.common.interfaces.FieldAndClassProccesorInterface;

@JProcessor
public class SetSizeProcessor implements FieldAndClassProccesorInterface {

    @Override
    public void process(Field field, Object object) {
        if (field.isAnnotationPresent(SetSize.class)) {
            SetSize annotation = field.getAnnotation(SetSize.class);
            field.setAccessible(true);
            try {
                Object value = field.get(object);
                if (value instanceof Component) {
                    Component component = (Component) value;
                    component.setPreferredSize(new java.awt.Dimension(annotation.width(), annotation.heigth()));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void process(Class<?> clazz, Object object) {
        if (clazz.isAnnotationPresent(SetSize.class)) {
            SetSize annotation = clazz.getAnnotation(SetSize.class);
            if (object instanceof Component) {
                Component component = (Component) object;
                component.setSize(annotation.width(), annotation.heigth());
            }
        }
    }

}
