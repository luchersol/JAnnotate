package com.jannotate.processors.classes;

import java.awt.Component;

import com.jannotate.annotations.classes.IsVisible;
import com.jannotate.common.ClassProcessorInterface;
import com.jannotate.common.JProcessor;

@JProcessor
public class IsVisibleProcessor implements ClassProcessorInterface {

    @Override
    public void process(Class<?> clazz, Object object) {
        if(clazz.isAnnotationPresent(IsVisible.class)){
            IsVisible annotation = clazz.getAnnotation(IsVisible.class);
            Component component = (Component) object;
            component.setVisible(annotation.value());
        }
    }
    
}
