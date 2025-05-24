package io.github.luchersol.processors.methods.handlers.single.hierarchy;

import java.awt.event.HierarchyBoundsListener;
import java.lang.reflect.Method;

import io.github.luchersol.annotations.methods.handlers.single.hierarchy.HierarchyBoundsListenerHandler;
import io.github.luchersol.common.abstractClasses.AbstractListenerHandlerProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.common.exceptions.LogException;

@JProcessor
public class HierarchyBoundsListenerHandlerProcessor
        extends AbstractListenerHandlerProcessor<HierarchyBoundsListenerHandler, HierarchyBoundsListener> {

    @Override
    public void process(Method method, Object object, HierarchyBoundsListenerHandler annotation)
            throws LogException {
        process(method, object, annotation, "addHierarchyBoundsListener");
    }

}
