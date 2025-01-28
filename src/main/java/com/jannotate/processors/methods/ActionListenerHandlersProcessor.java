package com.jannotate.processors.methods;

import java.lang.reflect.Method;

import com.jannotate.annotations.methods.ActionListenerHandler;
import com.jannotate.annotations.methods.ActionListenerHandlers;
import com.jannotate.common.abstractClasses.AbstractGroupedListenerHandlerProcessor;
import com.jannotate.common.annotations.JProcessor;

@JProcessor
public class ActionListenerHandlersProcessor extends AbstractGroupedListenerHandlerProcessor<ActionListenerHandlerProcessor, ActionListenerHandler, ActionListenerHandlers> {

    @Override
    public Class<ActionListenerHandlerProcessor> getProcessorClass() {
        return ActionListenerHandlerProcessor.class;
    }

    @Override
    public Class<ActionListenerHandler> getAnnotationSingleClass() {
        return ActionListenerHandler.class;
    }

    @Override
    public Class<ActionListenerHandlers> getAnnotationGroupClass() {
        return ActionListenerHandlers.class;
    }
    
}
