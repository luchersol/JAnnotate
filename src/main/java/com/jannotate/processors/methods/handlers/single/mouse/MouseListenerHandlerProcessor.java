package com.jannotate.processors.methods.handlers.single.mouse;

import java.awt.event.MouseListener;
import java.lang.reflect.Method;

import com.jannotate.annotations.methods.handlers.single.mouse.MouseListenerHandler;
import com.jannotate.common.abstractClasses.AbstractListenerHandlerProcessor;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.common.exceptions.SevereException;

@JProcessor
public class MouseListenerHandlerProcessor
        extends AbstractListenerHandlerProcessor<MouseListenerHandler, MouseListener> {

    @Override
    public void process(Method method, Object object, MouseListenerHandler annotation) throws SevereException {
        process(method, object, annotation, "addMouseListener");
    }

}
