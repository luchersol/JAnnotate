package com.jannotate.processors.methods.handlers.group;

import com.jannotate.annotations.methods.handlers.group.ContainerListenerHandlers;
import com.jannotate.annotations.methods.handlers.single.ContainerListenerHandler;
import com.jannotate.common.abstractClasses.AbstractGroupedListenerHandlerProcessor;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.processors.methods.handlers.single.ContainerListenerHandlerProcessor;

@JProcessor
public class ContainerListenerHandlersProcessor extends
                AbstractGroupedListenerHandlerProcessor<ContainerListenerHandlerProcessor, ContainerListenerHandler, ContainerListenerHandlers> {
}
