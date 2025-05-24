package io.github.luchersol.processors.methods.handlers.single;

import java.awt.event.KeyListener;
import java.lang.reflect.Method;

import io.github.luchersol.annotations.methods.handlers.single.KeyListenerHandler;
import io.github.luchersol.common.abstractClasses.AbstractListenerHandlerProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.common.exceptions.LogException;

@JProcessor
public class KeyListenerHandlerProcessor extends AbstractListenerHandlerProcessor<KeyListenerHandler, KeyListener> {

    @Override
    public void process(Method method, Object object, KeyListenerHandler annotation) throws LogException {
        process(method, object, annotation, "addKeyListener");
    }

}
