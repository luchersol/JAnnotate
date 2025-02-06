package com.jannotate.processors.methods.handlers.single.hierarchy;

import java.awt.event.HierarchyBoundsListener;
import java.lang.reflect.Method;

import com.jannotate.annotations.methods.handlers.single.hierarchy.HierarchyBoundsListenerHandler;
import com.jannotate.common.abstractClasses.AbstractListenerHandlerProcessor;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.common.exceptions.SevereException;

@JProcessor
public class HierarchyBoundsListenerHandlerProcessor
        extends AbstractListenerHandlerProcessor<HierarchyBoundsListenerHandler, HierarchyBoundsListener> {

    @Override
    public void process(Method method, Object object, HierarchyBoundsListenerHandler annotation)
            throws SevereException {
        process(method, object, annotation, "addHierarchyBoundsListener");
    }

}
