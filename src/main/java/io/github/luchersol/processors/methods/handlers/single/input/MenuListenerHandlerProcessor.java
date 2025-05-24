package io.github.luchersol.processors.methods.handlers.single.input;

import java.lang.reflect.Method;

import javax.swing.event.MenuListener;

import io.github.luchersol.annotations.methods.handlers.single.input.MenuListenerHandler;
import io.github.luchersol.common.abstractClasses.AbstractListenerHandlerProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.common.exceptions.LogException;

@JProcessor
public class MenuListenerHandlerProcessor
        extends AbstractListenerHandlerProcessor<MenuListenerHandler, MenuListener> {

    @Override
    public void process(Method method, Object object, MenuListenerHandler annotation) throws LogException {
        process(method, object, annotation, "addMenuListener");
    }

}
