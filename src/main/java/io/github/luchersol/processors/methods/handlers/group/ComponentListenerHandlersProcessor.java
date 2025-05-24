package io.github.luchersol.processors.methods.handlers.group;

import io.github.luchersol.annotations.methods.handlers.group.ComponentListenerHandlers;
import io.github.luchersol.annotations.methods.handlers.single.ComponentListenerHandler;
import io.github.luchersol.common.abstractClasses.AbstractGroupedListenerHandlerProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.processors.methods.handlers.single.ComponentListenerHandlerProcessor;

@JProcessor
public class ComponentListenerHandlersProcessor extends
                AbstractGroupedListenerHandlerProcessor<ComponentListenerHandlerProcessor, ComponentListenerHandler, ComponentListenerHandlers> {
}
