package io.github.luchersol.processors.methods.handlers.group.window;

import io.github.luchersol.annotations.methods.handlers.group.window.WindowStateListenerHandlers;
import io.github.luchersol.annotations.methods.handlers.single.window.WindowStateListenerHandler;
import io.github.luchersol.common.abstractClasses.AbstractGroupedListenerHandlerProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.processors.methods.handlers.single.window.WindowStateListenerHandlerProcessor;

@JProcessor
public class WindowStateListenerHandlersProcessor extends
                AbstractGroupedListenerHandlerProcessor<WindowStateListenerHandlerProcessor, WindowStateListenerHandler, WindowStateListenerHandlers> {
}
