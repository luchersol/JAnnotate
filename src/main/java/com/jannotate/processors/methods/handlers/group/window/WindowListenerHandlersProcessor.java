package com.jannotate.processors.methods.handlers.group.window;

import com.jannotate.annotations.methods.handlers.group.window.WindowListenerHandlers;
import com.jannotate.annotations.methods.handlers.single.window.WindowListenerHandler;
import com.jannotate.common.abstractClasses.AbstractGroupedListenerHandlerProcessor;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.processors.methods.handlers.single.window.WindowListenerHandlerProcessor;

@JProcessor
public class WindowListenerHandlersProcessor extends
        AbstractGroupedListenerHandlerProcessor<WindowListenerHandlerProcessor, WindowListenerHandler, WindowListenerHandlers> {
}
