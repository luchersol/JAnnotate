package io.github.luchersol.processors.methods.handlers.group.mouse;

import io.github.luchersol.annotations.methods.handlers.group.mouse.MouseWheelListenerHandlers;
import io.github.luchersol.annotations.methods.handlers.single.mouse.MouseWheelListenerHandler;
import io.github.luchersol.common.abstractClasses.AbstractGroupedListenerHandlerProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.processors.methods.handlers.single.mouse.MouseWheelListenerHandlerProcessor;

@JProcessor
public class MouseWheelListenerHandlersProcessor extends
                AbstractGroupedListenerHandlerProcessor<MouseWheelListenerHandlerProcessor, MouseWheelListenerHandler, MouseWheelListenerHandlers> {
}
