package com.jannotate.processors.methods.handlers.single.input;

import java.lang.reflect.Method;

import javax.swing.event.PopupMenuListener;

import com.jannotate.annotations.methods.handlers.single.input.PopupMenuListenerHandler;
import com.jannotate.common.abstractClasses.AbstractListenerHandlerProcessor;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.common.exceptions.LogException;

@JProcessor
public class PopupMenuListenerHandlerProcessor
        extends AbstractListenerHandlerProcessor<PopupMenuListenerHandler, PopupMenuListener> {

    @Override
    public void process(Method method, Object object, PopupMenuListenerHandler annotation) throws LogException {
        process(method, object, annotation, "addPopupMenuListener");
    }

}
