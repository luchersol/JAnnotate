package com.jannotate.processors.methods.handlers.single.input;

import java.lang.reflect.Method;

import javax.swing.event.MenuKeyListener;

import com.jannotate.annotations.methods.handlers.single.input.MenuKeyListenerHandler;
import com.jannotate.common.abstractClasses.AbstractListenerHandlerProcessor;
import com.jannotate.common.annotations.JProcessor;

@JProcessor
public class MenuKeyListenerHandlerProcessor
        extends AbstractListenerHandlerProcessor<MenuKeyListenerHandler, MenuKeyListener> {

    @Override
    public void process(Method method, Object object, MenuKeyListenerHandler annotation) {
        process(method, object, annotation, "addMenuKeyListener");
    }

}
