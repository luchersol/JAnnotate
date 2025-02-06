package com.jannotate.processors.methods.handlers.single.scroll;

import java.awt.event.ItemListener;
import java.lang.reflect.Method;

import com.jannotate.annotations.methods.handlers.single.scroll.ItemListenerHandler;
import com.jannotate.common.abstractClasses.AbstractListenerHandlerProcessor;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.common.exceptions.SevereException;

@JProcessor
public class ItemListenerHandlerProcessor
        extends AbstractListenerHandlerProcessor<ItemListenerHandler, ItemListener> {

    @Override
    public void process(Method method, Object object, ItemListenerHandler annotation) throws SevereException {
        process(method, object, annotation, "addItemListener");
    }

}
