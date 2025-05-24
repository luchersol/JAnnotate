package io.github.luchersol.processors.methods.handlers.single.input;

import java.awt.event.InputMethodListener;
import java.lang.reflect.Method;

import io.github.luchersol.annotations.methods.handlers.single.input.InputMethodListenerHandler;
import io.github.luchersol.common.abstractClasses.AbstractListenerHandlerProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.common.exceptions.LogException;

@JProcessor
public class InputMethodListenerHandlerProcessor
        extends AbstractListenerHandlerProcessor<InputMethodListenerHandler, InputMethodListener> {

    @Override
    public void process(Method method, Object object, InputMethodListenerHandler annotation) throws LogException {
        process(method, object, annotation, "addInputMethodListener");
    }

}
