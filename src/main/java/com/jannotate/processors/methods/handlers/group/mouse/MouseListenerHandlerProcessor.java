package com.jannotate.processors.methods.handlers.group.mouse;

import com.jannotate.annotations.methods.handlers.group.input.PopupMenuListenerHandlers;
import com.jannotate.annotations.methods.handlers.single.input.PopupMenuListenerHandler;
import com.jannotate.common.abstractClasses.AbstractGroupedListenerHandlerProcessor;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.processors.methods.handlers.single.input.PopupMenuListenerHandlerProcessor;

@JProcessor
public class MouseListenerHandlerProcessor extends
        AbstractGroupedListenerHandlerProcessor<PopupMenuListenerHandlerProcessor, PopupMenuListenerHandler, PopupMenuListenerHandlers> {
}
