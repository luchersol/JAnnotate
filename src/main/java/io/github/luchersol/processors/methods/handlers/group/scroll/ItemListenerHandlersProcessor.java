package io.github.luchersol.processors.methods.handlers.group.scroll;

import io.github.luchersol.annotations.methods.handlers.group.scroll.ItemListenerHandlers;
import io.github.luchersol.annotations.methods.handlers.single.scroll.ItemListenerHandler;
import io.github.luchersol.common.abstractClasses.AbstractGroupedListenerHandlerProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.processors.methods.handlers.single.scroll.ItemListenerHandlerProcessor;

@JProcessor
public class ItemListenerHandlersProcessor extends
                AbstractGroupedListenerHandlerProcessor<ItemListenerHandlerProcessor, ItemListenerHandler, ItemListenerHandlers> {
}
