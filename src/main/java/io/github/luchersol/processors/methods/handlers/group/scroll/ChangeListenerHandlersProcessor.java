package com.jannotate.processors.methods.handlers.group.scroll;

import com.jannotate.annotations.methods.handlers.group.scroll.ChangeListenerHandlers;
import com.jannotate.annotations.methods.handlers.single.scroll.ChangeListenerHandler;
import com.jannotate.common.abstractClasses.AbstractGroupedListenerHandlerProcessor;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.processors.methods.handlers.single.scroll.ChangeListenerHandlerProcessor;

@JProcessor
public class ChangeListenerHandlersProcessor extends AbstractGroupedListenerHandlerProcessor<ChangeListenerHandlerProcessor, ChangeListenerHandler, ChangeListenerHandlers> {
}
