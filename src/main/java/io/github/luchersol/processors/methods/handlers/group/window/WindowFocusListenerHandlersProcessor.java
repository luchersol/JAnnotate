package io.github.luchersol.processors.methods.handlers.group.window;

import io.github.luchersol.annotations.methods.handlers.group.window.WindowFocusListenerHandlers;
import io.github.luchersol.annotations.methods.handlers.single.window.WindowFocusListenerHandler;
import io.github.luchersol.common.abstractClasses.AbstractGroupedListenerHandlerProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.processors.methods.handlers.single.window.WindowFocusListenerHandlerProcessor;

@JProcessor
public class WindowFocusListenerHandlersProcessor extends
                AbstractGroupedListenerHandlerProcessor<WindowFocusListenerHandlerProcessor, WindowFocusListenerHandler, WindowFocusListenerHandlers> {
}
