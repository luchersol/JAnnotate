package io.github.luchersol.processors.methods.handlers.single.input;

import java.lang.reflect.Method;

import javax.swing.event.MenuKeyListener;

import io.github.luchersol.annotations.methods.handlers.single.input.MenuKeyListenerHandler;
import io.github.luchersol.common.abstractClasses.AbstractListenerHandlerProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.common.exceptions.LogException;

@JProcessor
public class MenuKeyListenerHandlerProcessor
        extends AbstractListenerHandlerProcessor<MenuKeyListenerHandler, MenuKeyListener> {

    @Override
    public void process(Method method, Object object, MenuKeyListenerHandler annotation) throws LogException {
        process(method, object, annotation, "addMenuKeyListener");
    }

}
