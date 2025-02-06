package com.jannotate.processors.methods.handlers.single.window;

import java.awt.event.WindowListener;
import java.lang.reflect.Method;

import com.jannotate.annotations.methods.handlers.single.window.WindowListenerHandler;
import com.jannotate.common.abstractClasses.AbstractListenerHandlerProcessor;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.common.exceptions.SevereException;

@JProcessor
public class WindowListenerHandlerProcessor
        extends AbstractListenerHandlerProcessor<WindowListenerHandler, WindowListener> {

    @Override
    public void process(Method method, Object object, WindowListenerHandler annotation) throws SevereException {
        process(method, object, annotation, "addWindowListener");
    }

}
