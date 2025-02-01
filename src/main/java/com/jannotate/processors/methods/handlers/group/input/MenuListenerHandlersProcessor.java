package com.jannotate.processors.methods.handlers.group.input;

import com.jannotate.annotations.methods.handlers.group.input.MenuListenerHandlers;
import com.jannotate.annotations.methods.handlers.single.input.MenuListenerHandler;
import com.jannotate.common.abstractClasses.AbstractGroupedListenerHandlerProcessor;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.processors.methods.handlers.single.input.MenuListenerHandlerProcessor;

@JProcessor
public class MenuListenerHandlersProcessor extends
        AbstractGroupedListenerHandlerProcessor<MenuListenerHandlerProcessor, MenuListenerHandler, MenuListenerHandlers> {
}
