package com.jannotate.processors.methods.handlers.group;

import com.jannotate.annotations.methods.handlers.group.FocusListenerHandlers;
import com.jannotate.annotations.methods.handlers.single.FocusListenerHandler;
import com.jannotate.common.abstractClasses.AbstractGroupedListenerHandlerProcessor;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.processors.methods.handlers.single.FocusListenerHandlerProcessor;

@JProcessor
public class FocusListenerHandlersProcessor extends
                AbstractGroupedListenerHandlerProcessor<FocusListenerHandlerProcessor, FocusListenerHandler, FocusListenerHandlers> {
}
