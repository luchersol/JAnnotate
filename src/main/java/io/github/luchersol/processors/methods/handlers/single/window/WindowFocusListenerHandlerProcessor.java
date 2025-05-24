package io.github.luchersol.processors.methods.handlers.single.window;

import java.awt.event.WindowFocusListener;
import java.lang.reflect.Method;

import io.github.luchersol.annotations.methods.handlers.single.window.WindowFocusListenerHandler;
import io.github.luchersol.common.abstractClasses.AbstractListenerHandlerProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.common.exceptions.LogException;

@JProcessor
public class WindowFocusListenerHandlerProcessor
        extends AbstractListenerHandlerProcessor<WindowFocusListenerHandler, WindowFocusListener> {

    @Override
    public void process(Method method, Object object, WindowFocusListenerHandler annotation) throws LogException {
        process(method, object, annotation, "addWindowFocusListener");
    }

}
