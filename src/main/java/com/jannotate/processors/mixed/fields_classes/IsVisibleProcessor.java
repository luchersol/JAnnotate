package com.jannotate.processors.mixed.fields_classes;

import java.awt.Component;
import java.lang.reflect.Field;

import com.jannotate.annotations.mixed.fields_classes.IsVisible;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.common.interfaces.FieldAndClassProccesorInterface;

@JProcessor
public class IsVisibleProcessor implements FieldAndClassProccesorInterface {

    @Override
    public void process(Field field, Object object) {
        if(field.isAnnotationPresent(IsVisible.class)){
            try {
                IsVisible annotation = field.getAnnotation(IsVisible.class);
                field.setAccessible(true);
                Component component = (Component) field.get(object);
                component.setVisible(annotation.value());
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void process(Class<?> clazz, Object object) {
        if(clazz.isAnnotationPresent(IsVisible.class)){
            IsVisible annotation = clazz.getAnnotation(IsVisible.class);
            Component component = (Component) object;
            component.setVisible(annotation.value());
        }
    }

}
