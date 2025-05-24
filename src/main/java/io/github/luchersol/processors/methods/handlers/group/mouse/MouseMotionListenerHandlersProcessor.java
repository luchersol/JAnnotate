package com.jannotate.processors.methods.handlers.group.mouse;

import com.jannotate.annotations.methods.handlers.group.mouse.MouseMotionListenerHandlers;
import com.jannotate.annotations.methods.handlers.single.mouse.MouseMotionListenerHandler;
import com.jannotate.common.abstractClasses.AbstractGroupedListenerHandlerProcessor;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.processors.methods.handlers.single.mouse.MouseMotionListenerHandlerProcessor;

@JProcessor
public class MouseMotionListenerHandlersProcessor extends AbstractGroupedListenerHandlerProcessor<MouseMotionListenerHandlerProcessor, MouseMotionListenerHandler, MouseMotionListenerHandlers> {
}
