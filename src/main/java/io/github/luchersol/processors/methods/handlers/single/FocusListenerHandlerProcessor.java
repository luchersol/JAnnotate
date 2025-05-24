package io.github.luchersol.processors.methods.handlers.single;

import java.awt.event.FocusListener;
import java.lang.reflect.Method;

import io.github.luchersol.annotations.methods.handlers.single.FocusListenerHandler;
import io.github.luchersol.common.abstractClasses.AbstractListenerHandlerProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.common.exceptions.LogException;

@JProcessor
public class FocusListenerHandlerProcessor
        extends AbstractListenerHandlerProcessor<FocusListenerHandler, FocusListener> {

    @Override
    public void process(Method method, Object object, FocusListenerHandler annotation) throws LogException {
        process(method, object, annotation, "addFocusListener");
    }

}
