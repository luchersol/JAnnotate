package com.jannotate.processors.methods;

import java.awt.event.ActionListener;
import java.lang.reflect.Method;

import com.jannotate.annotations.methods.ActionListenerHandler;
import com.jannotate.common.abstractClasses.AbstractListenerHandlerProcessor;
import com.jannotate.common.annotations.JProcessor;

@JProcessor
public class ActionListenerHandlerProcessor extends AbstractListenerHandlerProcessor<ActionListenerHandler> {

    @Override
    protected Class<ActionListenerHandler> getAnnotationClass() {
        return ActionListenerHandler.class;
    }

    @Override
    public void bindSwingListenerHandler(Method method, Object object, ActionListenerHandler annotation) {
        try {
            Object component = getField(annotation.component(), object);
            Object[] parametros = parseArguments(method, annotation.args());
            Method addActionListener = getMethodWithParameters(component.getClass(), "addActionListener", ActionListener.class);
            addActionListener.setAccessible(true);
            ActionListener actionListener = (ActionListener) method.invoke(object, parametros);
            addActionListener.invoke(component, actionListener);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
