package io.github.luchersol.processors.methods.handlers.group.input;

import io.github.luchersol.annotations.methods.handlers.group.input.MenuKeyListenerHandlers;
import io.github.luchersol.annotations.methods.handlers.single.input.MenuKeyListenerHandler;
import io.github.luchersol.common.abstractClasses.AbstractGroupedListenerHandlerProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.processors.methods.handlers.single.input.MenuKeyListenerHandlerProcessor;

@JProcessor
public class MenuKeyListenerHandlersProcessor extends
                AbstractGroupedListenerHandlerProcessor<MenuKeyListenerHandlerProcessor, MenuKeyListenerHandler, MenuKeyListenerHandlers> {
}
