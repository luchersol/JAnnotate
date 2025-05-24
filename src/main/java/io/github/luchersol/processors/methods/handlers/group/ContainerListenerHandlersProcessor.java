package io.github.luchersol.processors.methods.handlers.group;

import io.github.luchersol.annotations.methods.handlers.group.ContainerListenerHandlers;
import io.github.luchersol.annotations.methods.handlers.single.ContainerListenerHandler;
import io.github.luchersol.common.abstractClasses.AbstractGroupedListenerHandlerProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.processors.methods.handlers.single.ContainerListenerHandlerProcessor;

@JProcessor
public class ContainerListenerHandlersProcessor extends
                AbstractGroupedListenerHandlerProcessor<ContainerListenerHandlerProcessor, ContainerListenerHandler, ContainerListenerHandlers> {
}
