package com.jannotate.processors.methods.handlers.single.mouse;

import java.awt.event.MouseWheelListener;
import java.lang.reflect.Method;

import com.jannotate.annotations.methods.handlers.single.mouse.MouseWheelListenerHandler;
import com.jannotate.common.abstractClasses.AbstractListenerHandlerProcessor;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.common.exceptions.SevereException;

@JProcessor
public class MouseWheelListenerHandlerProcessor
        extends AbstractListenerHandlerProcessor<MouseWheelListenerHandler, MouseWheelListener> {

    @Override
    public void process(Method method, Object object, MouseWheelListenerHandler annotation) throws SevereException {
        process(method, object, annotation, "addMouseWheelListener");
    }

}
