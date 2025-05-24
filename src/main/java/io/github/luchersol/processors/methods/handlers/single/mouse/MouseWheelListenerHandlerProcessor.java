package io.github.luchersol.processors.methods.handlers.single.mouse;

import java.awt.event.MouseWheelListener;
import java.lang.reflect.Method;

import io.github.luchersol.annotations.methods.handlers.single.mouse.MouseWheelListenerHandler;
import io.github.luchersol.common.abstractClasses.AbstractListenerHandlerProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.common.exceptions.LogException;

@JProcessor
public class MouseWheelListenerHandlerProcessor
        extends AbstractListenerHandlerProcessor<MouseWheelListenerHandler, MouseWheelListener> {

    @Override
    public void process(Method method, Object object, MouseWheelListenerHandler annotation) throws LogException {
        process(method, object, annotation, "addMouseWheelListener");
    }

}
