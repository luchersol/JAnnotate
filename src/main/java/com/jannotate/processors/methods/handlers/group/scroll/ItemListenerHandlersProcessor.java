package com.jannotate.processors.methods.handlers.group.scroll;

import com.jannotate.annotations.methods.handlers.group.scroll.ItemListenerHandlers;
import com.jannotate.annotations.methods.handlers.single.scroll.ItemListenerHandler;
import com.jannotate.common.abstractClasses.AbstractGroupedListenerHandlerProcessor;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.processors.methods.handlers.single.scroll.ItemListenerHandlerProcessor;

@JProcessor
public class ItemListenerHandlersProcessor extends
        AbstractGroupedListenerHandlerProcessor<ItemListenerHandlerProcessor, ItemListenerHandler, ItemListenerHandlers> {
}
