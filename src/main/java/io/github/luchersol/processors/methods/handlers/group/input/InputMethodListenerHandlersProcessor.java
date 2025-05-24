package io.github.luchersol.processors.methods.handlers.group.input;

import io.github.luchersol.annotations.methods.handlers.group.input.InputMethodListenerHandlers;
import io.github.luchersol.annotations.methods.handlers.single.input.InputMethodListenerHandler;
import io.github.luchersol.common.abstractClasses.AbstractGroupedListenerHandlerProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.processors.methods.handlers.single.input.InputMethodListenerHandlerProcessor;

@JProcessor
public class InputMethodListenerHandlersProcessor extends
                AbstractGroupedListenerHandlerProcessor<InputMethodListenerHandlerProcessor, InputMethodListenerHandler, InputMethodListenerHandlers> {
}
