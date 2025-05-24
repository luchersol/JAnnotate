package io.github.luchersol.processors.methods.handlers.single.mouse;

import java.awt.event.MouseListener;
import java.lang.reflect.Method;

import io.github.luchersol.annotations.methods.handlers.single.mouse.MouseListenerHandler;
import io.github.luchersol.common.abstractClasses.AbstractListenerHandlerProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.common.exceptions.LogException;

@JProcessor
public class MouseListenerHandlerProcessor
        extends AbstractListenerHandlerProcessor<MouseListenerHandler, MouseListener> {

    @Override
    public void process(Method method, Object object, MouseListenerHandler annotation) throws LogException {
        process(method, object, annotation, "addMouseListener");
    }

}
