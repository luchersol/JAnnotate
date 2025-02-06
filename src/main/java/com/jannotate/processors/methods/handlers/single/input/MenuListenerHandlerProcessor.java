package com.jannotate.processors.methods.handlers.single.input;

import java.lang.reflect.Method;

import javax.swing.event.MenuListener;

import com.jannotate.annotations.methods.handlers.single.input.MenuListenerHandler;
import com.jannotate.common.abstractClasses.AbstractListenerHandlerProcessor;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.common.exceptions.SevereException;

@JProcessor
public class MenuListenerHandlerProcessor
        extends AbstractListenerHandlerProcessor<MenuListenerHandler, MenuListener> {

    @Override
    public void process(Method method, Object object, MenuListenerHandler annotation) throws SevereException {
        process(method, object, annotation, "addMenuListener");
    }

}
