package com.jannotate.processors.fields.listeners.single;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.swing.AbstractButton;

import com.jannotate.annotations.fields.listeners.single.ComponentActionListener;
import com.jannotate.common.abstractClasses.AbstractListenerProcessor;
import com.jannotate.common.annotations.JProcessor;

@JProcessor
public class ComponentActionListenerProcessor extends AbstractListenerProcessor<ComponentActionListener> {

    @Override
    public void process(Field field, Object object, ComponentActionListener annotation) {
        try {
            AbstractButton component = getFieldAs(field, object, AbstractButton.class);
            Method method = getMethod(object.getClass(), annotation.method(), annotation.type_args());
            Object[] args = parseArguments(method, annotation.args());
            component.addActionListener(e -> {
                try {
                    method.invoke(object, args);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
