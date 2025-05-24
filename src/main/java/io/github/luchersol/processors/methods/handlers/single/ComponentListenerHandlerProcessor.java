package io.github.luchersol.processors.methods.handlers.single;

import java.awt.event.ComponentListener;
import java.lang.reflect.Method;

import io.github.luchersol.annotations.methods.handlers.single.ComponentListenerHandler;
import io.github.luchersol.common.abstractClasses.AbstractListenerHandlerProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.common.exceptions.LogException;

@JProcessor
public class ComponentListenerHandlerProcessor
        extends AbstractListenerHandlerProcessor<ComponentListenerHandler, ComponentListener> {

    @Override
    public void process(Method method, Object object, ComponentListenerHandler annotation) throws LogException {
        process(method, object, annotation, "addComponentListener");
    }

}
