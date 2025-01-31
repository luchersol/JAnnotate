package com.jannotate.processors.methods.handlers.single.input;

import java.lang.reflect.Method;

import javax.swing.event.PopupMenuListener;

import com.jannotate.annotations.methods.handlers.single.input.PopupMenuListenerHandler;
import com.jannotate.common.abstractClasses.AbstractListenerHandlerProcessor;
import com.jannotate.common.annotations.JProcessor;

@JProcessor
public class PopupMenuListenerHandlerProcessor
        extends AbstractListenerHandlerProcessor<PopupMenuListenerHandler, PopupMenuListener> {

    @Override
    public void process(Method method, Object object, PopupMenuListenerHandler annotation) {
        process(method, object, annotation, "addPopupMenuListener");
    }

}
