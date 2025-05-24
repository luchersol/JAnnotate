package io.github.luchersol.processors.methods.handlers.single.mouse;

import java.awt.event.MouseMotionListener;
import java.lang.reflect.Method;

import io.github.luchersol.annotations.methods.handlers.single.mouse.MouseMotionListenerHandler;
import io.github.luchersol.common.abstractClasses.AbstractListenerHandlerProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.common.exceptions.LogException;

@JProcessor
public class MouseMotionListenerHandlerProcessor
        extends AbstractListenerHandlerProcessor<MouseMotionListenerHandler, MouseMotionListener> {

    @Override
    public void process(Method method, Object object, MouseMotionListenerHandler annotation) throws LogException {
        process(method, object, annotation, "addMouseMotionListener");
    }

}
