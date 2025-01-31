package com.jannotate.processors.methods.handlers.single;

import java.awt.event.ContainerListener;
import java.lang.reflect.Method;

import com.jannotate.annotations.methods.handlers.single.ContainerListenerHandler;
import com.jannotate.common.abstractClasses.AbstractListenerHandlerProcessor;
import com.jannotate.common.annotations.JProcessor;

@JProcessor
public class ContainerListenerHandlerProcessor
        extends AbstractListenerHandlerProcessor<ContainerListenerHandler, ContainerListener> {

    @Override
    public void process(Method method, Object object, ContainerListenerHandler annotation) {
        process(method, object, annotation, "addContainerListener");
    }

}
