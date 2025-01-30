package com.jannotate.processors.methods.handlers.single;

import java.awt.event.ActionListener;
import java.lang.reflect.Method;

import com.jannotate.annotations.methods.handlers.single.ActionListenerHandler;
import com.jannotate.common.abstractClasses.AbstractListenerHandlerProcessor;
import com.jannotate.common.annotations.JProcessor;

@JProcessor
public class ActionListenerHandlerProcessor
        extends AbstractListenerHandlerProcessor<ActionListenerHandler, ActionListener> {

    @Override
    public void process(Method method, Object object, ActionListenerHandler annotation) {
        process(method, object, annotation, "addActionListener");
    }

}
