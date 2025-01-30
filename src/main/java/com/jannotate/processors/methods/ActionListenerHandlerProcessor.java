package com.jannotate.processors.methods;

import java.awt.event.ActionListener;
import java.lang.reflect.Method;

import com.jannotate.annotations.methods.handlers.single.ActionListenerHandler;
import com.jannotate.common.abstractClasses.AbstractListenerHandlerProcessor;
import com.jannotate.common.annotations.JProcessor;

@JProcessor
public class ActionListenerHandlerProcessor extends AbstractListenerHandlerProcessor<ActionListenerHandler> {

    @Override
    public void process(Method method, Object object, ActionListenerHandler annotation) {
        try {
            Object component = getFieldAs(annotation.component(), object, Object.class);
            Object[] parametros = parseArguments(method, annotation.args());
            Method addActionListener = getMethod(component.getClass(), "addActionListener", ActionListener.class);
            ActionListener actionListener = (ActionListener) method.invoke(object, parametros);
            addActionListener.invoke(component, actionListener);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
