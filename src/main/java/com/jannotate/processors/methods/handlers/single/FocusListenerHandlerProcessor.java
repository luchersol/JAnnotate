package com.jannotate.processors.methods.handlers.single;

import java.awt.event.FocusListener;
import java.lang.reflect.Method;

import com.jannotate.annotations.methods.handlers.single.FocusListenerHandler;
import com.jannotate.common.abstractClasses.AbstractListenerHandlerProcessor;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.common.exceptions.LogException;

@JProcessor
public class FocusListenerHandlerProcessor
        extends AbstractListenerHandlerProcessor<FocusListenerHandler, FocusListener> {

    @Override
    public void process(Method method, Object object, FocusListenerHandler annotation) throws LogException {
        process(method, object, annotation, "addFocusListener");
    }

}
