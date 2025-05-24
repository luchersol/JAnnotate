package io.github.luchersol.processors.methods.handlers.single.scroll;

import java.awt.event.ItemListener;
import java.lang.reflect.Method;

import io.github.luchersol.annotations.methods.handlers.single.scroll.ItemListenerHandler;
import io.github.luchersol.common.abstractClasses.AbstractListenerHandlerProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.common.exceptions.LogException;

@JProcessor
public class ItemListenerHandlerProcessor
        extends AbstractListenerHandlerProcessor<ItemListenerHandler, ItemListener> {

    @Override
    public void process(Method method, Object object, ItemListenerHandler annotation) throws LogException {
        process(method, object, annotation, "addItemListener");
    }

}
