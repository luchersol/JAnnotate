package com.jannotate.processors.fields;

import java.lang.reflect.Field;

import javax.swing.JComponent;

import com.jannotate.annotations.fields.SetBound;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.common.interfaces.FieldProcessorInterface;

@JProcessor
public class SetBoundProcessor implements FieldProcessorInterface {

    @Override
    public void process(Field field, Object object) {
        if(field.isAnnotationPresent(SetBound.class)){
            SetBound annotation = field.getAnnotation(SetBound.class);
            int x = annotation.x(), y = annotation.y(), width = annotation.width(), heigth = annotation.heigth();
            field.setAccessible(true);
            try {
                Object value = field.get(object);
                if (value instanceof JComponent) {
                    JComponent component = (JComponent) value;
                    component.setBounds(x,y,width,heigth);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
    
}
