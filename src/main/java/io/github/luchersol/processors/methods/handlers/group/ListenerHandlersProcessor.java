package io.github.luchersol.processors.methods.handlers.group;

import io.github.luchersol.annotations.methods.handlers.group.ListenerHandlers;
import io.github.luchersol.annotations.methods.handlers.single.ListenerHandler;
import io.github.luchersol.common.abstractClasses.AbstractGroupedListenerHandlerProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.processors.methods.handlers.single.ListenerHandlerProcessor;

@JProcessor
public class ListenerHandlersProcessor
                extends
                AbstractGroupedListenerHandlerProcessor<ListenerHandlerProcessor, ListenerHandler, ListenerHandlers> {
}
