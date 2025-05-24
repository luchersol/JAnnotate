package io.github.luchersol.processors.methods.handlers.group;

import io.github.luchersol.annotations.methods.handlers.group.ActionListenerHandlers;
import io.github.luchersol.annotations.methods.handlers.single.ActionListenerHandler;
import io.github.luchersol.common.abstractClasses.AbstractGroupedListenerHandlerProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.processors.methods.handlers.single.ActionListenerHandlerProcessor;

@JProcessor
public class ActionListenerHandlersProcessor extends
                AbstractGroupedListenerHandlerProcessor<ActionListenerHandlerProcessor, ActionListenerHandler, ActionListenerHandlers> {
}
