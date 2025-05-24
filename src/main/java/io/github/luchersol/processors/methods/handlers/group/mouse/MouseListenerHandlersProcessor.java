package io.github.luchersol.processors.methods.handlers.group.mouse;

import io.github.luchersol.annotations.methods.handlers.group.mouse.MouseListenerHandlers;
import io.github.luchersol.annotations.methods.handlers.single.mouse.MouseListenerHandler;
import io.github.luchersol.common.abstractClasses.AbstractGroupedListenerHandlerProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.processors.methods.handlers.single.mouse.MouseListenerHandlerProcessor;

@JProcessor
public class MouseListenerHandlersProcessor extends
                AbstractGroupedListenerHandlerProcessor<MouseListenerHandlerProcessor, MouseListenerHandler, MouseListenerHandlers> {
}
