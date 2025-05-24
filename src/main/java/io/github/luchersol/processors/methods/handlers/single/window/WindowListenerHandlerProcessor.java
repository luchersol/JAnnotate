package io.github.luchersol.processors.methods.handlers.single.window;

import java.awt.event.WindowListener;
import java.lang.reflect.Method;

import io.github.luchersol.annotations.methods.handlers.single.window.WindowListenerHandler;
import io.github.luchersol.common.abstractClasses.AbstractListenerHandlerProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.common.exceptions.LogException;

@JProcessor
public class WindowListenerHandlerProcessor
        extends AbstractListenerHandlerProcessor<WindowListenerHandler, WindowListener> {

    @Override
    public void process(Method method, Object object, WindowListenerHandler annotation) throws LogException {
        process(method, object, annotation, "addWindowListener");
    }

}
