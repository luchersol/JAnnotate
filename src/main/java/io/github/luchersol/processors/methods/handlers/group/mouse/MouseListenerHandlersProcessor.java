package com.jannotate.processors.methods.handlers.group.mouse;

import com.jannotate.annotations.methods.handlers.group.mouse.MouseListenerHandlers;
import com.jannotate.annotations.methods.handlers.single.mouse.MouseListenerHandler;
import com.jannotate.common.abstractClasses.AbstractGroupedListenerHandlerProcessor;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.processors.methods.handlers.single.mouse.MouseListenerHandlerProcessor;

@JProcessor
public class MouseListenerHandlersProcessor extends AbstractGroupedListenerHandlerProcessor<MouseListenerHandlerProcessor, MouseListenerHandler, MouseListenerHandlers> {
}
