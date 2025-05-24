package io.github.luchersol.processors.methods.handlers.single.hierarchy;

import java.awt.event.HierarchyListener;
import java.lang.reflect.Method;

import io.github.luchersol.annotations.methods.handlers.single.hierarchy.HierarchyListenerHandler;
import io.github.luchersol.common.abstractClasses.AbstractListenerHandlerProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.common.exceptions.LogException;

@JProcessor
public class HierarchyListenerHandlerProcessor
        extends AbstractListenerHandlerProcessor<HierarchyListenerHandler, HierarchyListener> {

    @Override
    public void process(Method method, Object object, HierarchyListenerHandler annotation) throws LogException {
        process(method, object, annotation, "addHierarchyListener");
    }

}
