package com.jannotate.processors.methods.handlers.group;

import com.jannotate.annotations.methods.handlers.group.KeyListenerHandlers;
import com.jannotate.annotations.methods.handlers.single.KeyListenerHandler;
import com.jannotate.common.abstractClasses.AbstractGroupedListenerHandlerProcessor;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.processors.methods.handlers.single.KeyListenerHandlerProcessor;

@JProcessor
public class KeyListenerHandlersProcessor extends
        AbstractGroupedListenerHandlerProcessor<KeyListenerHandlerProcessor, KeyListenerHandler, KeyListenerHandlers> {
}
