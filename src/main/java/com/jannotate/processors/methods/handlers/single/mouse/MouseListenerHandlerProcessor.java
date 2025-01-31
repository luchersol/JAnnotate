package com.jannotate.processors.methods.handlers.single.mouse;

import java.awt.event.MouseListener;
import java.lang.reflect.Method;

import com.jannotate.annotations.methods.handlers.single.mouse.MouseListenerHandler;
import com.jannotate.common.abstractClasses.AbstractListenerHandlerProcessor;
import com.jannotate.common.annotations.JProcessor;

@JProcessor
public class MouseListenerHandlerProcessor
        extends AbstractListenerHandlerProcessor<MouseListenerHandler, MouseListener> {

    @Override
    public void process(Method method, Object object, MouseListenerHandler annotation) {
        process(method, object, annotation, "addMouseListener");
    }

}
