package com.jannotate.processors.methods.handlers.single.window;

import java.awt.event.WindowStateListener;
import java.lang.reflect.Method;

import com.jannotate.annotations.methods.handlers.single.window.WindowStateListenerHandler;
import com.jannotate.common.abstractClasses.AbstractListenerHandlerProcessor;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.common.exceptions.SevereException;

@JProcessor
public class WindowStateListenerHandlerProcessor
        extends AbstractListenerHandlerProcessor<WindowStateListenerHandler, WindowStateListener> {

    @Override
    public void process(Method method, Object object, WindowStateListenerHandler annotation) throws SevereException {
        process(method, object, annotation, "addWindowStateListener");
    }

}
