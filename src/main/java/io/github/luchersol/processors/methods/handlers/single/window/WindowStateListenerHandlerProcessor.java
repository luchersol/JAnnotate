package io.github.luchersol.processors.methods.handlers.single.window;

import java.awt.event.WindowStateListener;
import java.lang.reflect.Method;

import io.github.luchersol.annotations.methods.handlers.single.window.WindowStateListenerHandler;
import io.github.luchersol.common.abstractClasses.AbstractListenerHandlerProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.common.exceptions.LogException;

@JProcessor
public class WindowStateListenerHandlerProcessor
        extends AbstractListenerHandlerProcessor<WindowStateListenerHandler, WindowStateListener> {

    @Override
    public void process(Method method, Object object, WindowStateListenerHandler annotation) throws LogException {
        process(method, object, annotation, "addWindowStateListener");
    }

}
