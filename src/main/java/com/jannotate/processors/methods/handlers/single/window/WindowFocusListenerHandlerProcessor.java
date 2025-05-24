package com.jannotate.processors.methods.handlers.single.window;

import java.awt.event.WindowFocusListener;
import java.lang.reflect.Method;

import com.jannotate.annotations.methods.handlers.single.window.WindowFocusListenerHandler;
import com.jannotate.common.abstractClasses.AbstractListenerHandlerProcessor;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.common.exceptions.LogException;

@JProcessor
public class WindowFocusListenerHandlerProcessor
        extends AbstractListenerHandlerProcessor<WindowFocusListenerHandler, WindowFocusListener> {

    @Override
    public void process(Method method, Object object, WindowFocusListenerHandler annotation) throws LogException {
        process(method, object, annotation, "addWindowFocusListener");
    }

}
