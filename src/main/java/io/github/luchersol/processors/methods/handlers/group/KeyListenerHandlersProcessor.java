package io.github.luchersol.processors.methods.handlers.group;

import io.github.luchersol.annotations.methods.handlers.group.KeyListenerHandlers;
import io.github.luchersol.annotations.methods.handlers.single.KeyListenerHandler;
import io.github.luchersol.common.abstractClasses.AbstractGroupedListenerHandlerProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.processors.methods.handlers.single.KeyListenerHandlerProcessor;

@JProcessor
public class KeyListenerHandlersProcessor extends
                AbstractGroupedListenerHandlerProcessor<KeyListenerHandlerProcessor, KeyListenerHandler, KeyListenerHandlers> {
}
