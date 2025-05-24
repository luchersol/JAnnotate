package io.github.luchersol.processors.methods.handlers.group;

import io.github.luchersol.annotations.methods.handlers.group.FocusListenerHandlers;
import io.github.luchersol.annotations.methods.handlers.single.FocusListenerHandler;
import io.github.luchersol.common.abstractClasses.AbstractGroupedListenerHandlerProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.processors.methods.handlers.single.FocusListenerHandlerProcessor;

@JProcessor
public class FocusListenerHandlersProcessor extends
                AbstractGroupedListenerHandlerProcessor<FocusListenerHandlerProcessor, FocusListenerHandler, FocusListenerHandlers> {
}
