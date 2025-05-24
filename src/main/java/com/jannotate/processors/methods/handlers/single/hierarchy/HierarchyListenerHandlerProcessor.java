package com.jannotate.processors.methods.handlers.single.hierarchy;

import java.awt.event.HierarchyListener;
import java.lang.reflect.Method;

import com.jannotate.annotations.methods.handlers.single.hierarchy.HierarchyListenerHandler;
import com.jannotate.common.abstractClasses.AbstractListenerHandlerProcessor;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.common.exceptions.LogException;

@JProcessor
public class HierarchyListenerHandlerProcessor
        extends AbstractListenerHandlerProcessor<HierarchyListenerHandler, HierarchyListener> {

    @Override
    public void process(Method method, Object object, HierarchyListenerHandler annotation) throws LogException {
        process(method, object, annotation, "addHierarchyListener");
    }

}
