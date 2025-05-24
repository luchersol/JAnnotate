package com.jannotate.processors.methods.handlers.single;

import java.awt.event.KeyListener;
import java.lang.reflect.Method;

import com.jannotate.annotations.methods.handlers.single.KeyListenerHandler;
import com.jannotate.common.abstractClasses.AbstractListenerHandlerProcessor;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.common.exceptions.LogException;

@JProcessor
public class KeyListenerHandlerProcessor extends AbstractListenerHandlerProcessor<KeyListenerHandler, KeyListener> {

    @Override
    public void process(Method method, Object object, KeyListenerHandler annotation) throws LogException {
        process(method, object, annotation, "addKeyListener");
    }

}
