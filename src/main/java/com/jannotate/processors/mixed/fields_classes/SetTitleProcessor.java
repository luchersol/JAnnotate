package com.jannotate.processors.mixed.fields_classes;

import java.awt.Frame;
import java.lang.reflect.Field;

import com.jannotate.annotations.mixed.fields_classes.SetTitle;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.common.interfaces.FieldAndClassProccesorInterface;

@JProcessor
public class SetTitleProcessor implements FieldAndClassProccesorInterface  {

    @Override
    public void process(Field field, Object object) {
        if(field.isAnnotationPresent(SetTitle.class)){
            try{
                field.setAccessible(true);
                SetTitle annotation = field.getAnnotation(SetTitle.class);
                Object value = field.get(object);
                if(value instanceof Frame){
                    Frame frame = (Frame) value;
                    frame.setTitle(annotation.value());
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void process(Class<?> clazz, Object object) {
        if(clazz.isAnnotationPresent(SetTitle.class)){
            SetTitle annotation = clazz.getAnnotation(SetTitle.class);
            if(object instanceof Frame){
                Frame frame = (Frame) object;
                frame.setTitle(annotation.value());
            }
        }
    }
    
}
