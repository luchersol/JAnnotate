package com.jannotate.processors.fields.listeners.single;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.swing.AbstractButton;

import com.jannotate.annotations.fields.listeners.single.ComponentActionListener;
import com.jannotate.common.AbstractListenerProcessor;
import com.jannotate.common.JProcessor;

@JProcessor
public class ComponentActionListenerProcessor extends AbstractListenerProcessor<ComponentActionListener> {

    @Override
    protected Class<ComponentActionListener> getAnnotationClass() {
        return ComponentActionListener.class;
    }
    
    @Override
    public void bindSwingListener(Field field, Object object, ComponentActionListener annotation) {
        field.setAccessible(true);
        try {
            Object value = field.get(object);
            if (value instanceof AbstractButton) {
                AbstractButton component = (AbstractButton) value;
                String methodName = annotation.method();
                
                Method method = object.getClass().getDeclaredMethod(methodName);
                method.setAccessible(true);
                Object[] args = parseArguments(method, annotation.args());
                component.addActionListener(e -> {
                    try {
                        method.invoke(object, args);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }                    
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
