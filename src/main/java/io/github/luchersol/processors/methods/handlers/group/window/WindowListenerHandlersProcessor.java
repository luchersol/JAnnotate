package io.github.luchersol.processors.methods.handlers.group.window;

import io.github.luchersol.annotations.methods.handlers.group.window.WindowListenerHandlers;
import io.github.luchersol.annotations.methods.handlers.single.window.WindowListenerHandler;
import io.github.luchersol.common.abstractClasses.AbstractGroupedListenerHandlerProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.processors.methods.handlers.single.window.WindowListenerHandlerProcessor;

@JProcessor
public class WindowListenerHandlersProcessor extends
                AbstractGroupedListenerHandlerProcessor<WindowListenerHandlerProcessor, WindowListenerHandler, WindowListenerHandlers> {
}
