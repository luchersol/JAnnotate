package com.jannotate.processors.methods.handlers.single.mouse;

import java.awt.event.MouseMotionListener;
import java.lang.reflect.Method;

import com.jannotate.annotations.methods.handlers.single.mouse.MouseMotionListenerHandler;
import com.jannotate.common.abstractClasses.AbstractListenerHandlerProcessor;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.common.exceptions.SevereException;

@JProcessor
public class MouseMotionListenerHandlerProcessor
        extends AbstractListenerHandlerProcessor<MouseMotionListenerHandler, MouseMotionListener> {

    @Override
    public void process(Method method, Object object, MouseMotionListenerHandler annotation) throws SevereException {
        process(method, object, annotation, "addMouseMotionListener");
    }

}
