package io.github.luchersol.processors.methods.handlers.group.input;

import io.github.luchersol.annotations.methods.handlers.group.input.MenuListenerHandlers;
import io.github.luchersol.annotations.methods.handlers.single.input.MenuListenerHandler;
import io.github.luchersol.common.abstractClasses.AbstractGroupedListenerHandlerProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.processors.methods.handlers.single.input.MenuListenerHandlerProcessor;

@JProcessor
public class MenuListenerHandlersProcessor extends
                AbstractGroupedListenerHandlerProcessor<MenuListenerHandlerProcessor, MenuListenerHandler, MenuListenerHandlers> {
}
