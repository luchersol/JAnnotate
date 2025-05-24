package io.github.luchersol.processors.methods.handlers.single;

import java.awt.event.ActionListener;
import java.lang.reflect.Method;

import io.github.luchersol.annotations.methods.handlers.single.ActionListenerHandler;
import io.github.luchersol.common.abstractClasses.AbstractListenerHandlerProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.common.exceptions.LogException;

@JProcessor
public class ActionListenerHandlerProcessor
        extends AbstractListenerHandlerProcessor<ActionListenerHandler, ActionListener> {

    @Override
    public void process(Method method, Object object, ActionListenerHandler annotation) throws LogException {
        process(method, object, annotation, "addActionListener");
    }

}
