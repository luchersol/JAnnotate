package com.jannotate.processors.methods.handlers.single;

import java.awt.event.ComponentListener;
import java.lang.reflect.Method;

import com.jannotate.annotations.methods.handlers.single.ComponentListenerHandler;
import com.jannotate.common.abstractClasses.AbstractListenerHandlerProcessor;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.common.exceptions.SevereException;

@JProcessor
public class ComponentListenerHandlerProcessor
        extends AbstractListenerHandlerProcessor<ComponentListenerHandler, ComponentListener> {

    @Override
    public void process(Method method, Object object, ComponentListenerHandler annotation) throws SevereException {
        process(method, object, annotation, "addComponentListener");
    }

}
