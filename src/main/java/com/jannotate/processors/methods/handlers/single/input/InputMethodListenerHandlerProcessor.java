package com.jannotate.processors.methods.handlers.single.input;

import java.awt.event.InputMethodListener;
import java.lang.reflect.Method;

import com.jannotate.annotations.methods.handlers.single.input.InputMethodListenerHandler;
import com.jannotate.common.abstractClasses.AbstractListenerHandlerProcessor;
import com.jannotate.common.annotations.JProcessor;

@JProcessor
public class InputMethodListenerHandlerProcessor
        extends AbstractListenerHandlerProcessor<InputMethodListenerHandler, InputMethodListener> {

    @Override
    public void process(Method method, Object object, InputMethodListenerHandler annotation) {
        process(method, object, annotation, "addInputMethodListener");
    }

}
