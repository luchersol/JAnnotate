package com.jannotate.processors.methods.handlers.group;

import com.jannotate.annotations.methods.handlers.group.ListenerHandlers;
import com.jannotate.annotations.methods.handlers.single.ListenerHandler;
import com.jannotate.common.abstractClasses.AbstractGroupedListenerHandlerProcessor;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.processors.methods.handlers.single.ListenerHandlerProcessor;

@JProcessor
public class ListenerHandlersProcessor extends
                AbstractGroupedListenerHandlerProcessor<ListenerHandlerProcessor, ListenerHandler, ListenerHandlers> {
}
