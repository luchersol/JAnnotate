package io.github.luchersol.processors.methods.handlers.group.scroll;

import io.github.luchersol.annotations.methods.handlers.group.scroll.ChangeListenerHandlers;
import io.github.luchersol.annotations.methods.handlers.single.scroll.ChangeListenerHandler;
import io.github.luchersol.common.abstractClasses.AbstractGroupedListenerHandlerProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.processors.methods.handlers.single.scroll.ChangeListenerHandlerProcessor;

@JProcessor
public class ChangeListenerHandlersProcessor extends
                AbstractGroupedListenerHandlerProcessor<ChangeListenerHandlerProcessor, ChangeListenerHandler, ChangeListenerHandlers> {
}
