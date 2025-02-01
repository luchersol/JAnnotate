package com.jannotate.processors.methods.handlers.group.input;

import com.jannotate.annotations.methods.handlers.group.input.MenuKeyListenerHandlers;
import com.jannotate.annotations.methods.handlers.single.input.MenuKeyListenerHandler;
import com.jannotate.common.abstractClasses.AbstractGroupedListenerHandlerProcessor;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.processors.methods.handlers.single.input.MenuKeyListenerHandlerProcessor;

@JProcessor
public class MenuKeyListenerHandlersProcessor extends
        AbstractGroupedListenerHandlerProcessor<MenuKeyListenerHandlerProcessor, MenuKeyListenerHandler, MenuKeyListenerHandlers> {

}
