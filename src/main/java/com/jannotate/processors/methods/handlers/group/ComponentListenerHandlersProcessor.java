package com.jannotate.processors.methods.handlers.group;

import com.jannotate.annotations.methods.handlers.group.ComponentListenerHandlers;
import com.jannotate.annotations.methods.handlers.single.ComponentListenerHandler;
import com.jannotate.common.abstractClasses.AbstractGroupedListenerHandlerProcessor;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.processors.methods.handlers.single.ComponentListenerHandlerProcessor;

@JProcessor
public class ComponentListenerHandlersProcessor extends
        AbstractGroupedListenerHandlerProcessor<ComponentListenerHandlerProcessor, ComponentListenerHandler, ComponentListenerHandlers> {
}
