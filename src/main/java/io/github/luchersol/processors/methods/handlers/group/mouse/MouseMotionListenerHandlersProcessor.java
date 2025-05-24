package io.github.luchersol.processors.methods.handlers.group.mouse;

import io.github.luchersol.annotations.methods.handlers.group.mouse.MouseMotionListenerHandlers;
import io.github.luchersol.annotations.methods.handlers.single.mouse.MouseMotionListenerHandler;
import io.github.luchersol.common.abstractClasses.AbstractGroupedListenerHandlerProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.processors.methods.handlers.single.mouse.MouseMotionListenerHandlerProcessor;

@JProcessor
public class MouseMotionListenerHandlersProcessor extends
                AbstractGroupedListenerHandlerProcessor<MouseMotionListenerHandlerProcessor, MouseMotionListenerHandler, MouseMotionListenerHandlers> {
}
