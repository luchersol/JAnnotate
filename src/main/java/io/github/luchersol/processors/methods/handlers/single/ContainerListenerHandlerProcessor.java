package io.github.luchersol.processors.methods.handlers.single;

import java.awt.event.ContainerListener;
import java.lang.reflect.Method;

import io.github.luchersol.annotations.methods.handlers.single.ContainerListenerHandler;
import io.github.luchersol.common.abstractClasses.AbstractListenerHandlerProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.common.exceptions.LogException;

@JProcessor
public class ContainerListenerHandlerProcessor
        extends AbstractListenerHandlerProcessor<ContainerListenerHandler, ContainerListener> {

    @Override
    public void process(Method method, Object object, ContainerListenerHandler annotation) throws LogException {
        process(method, object, annotation, "addContainerListener");
    }

}
