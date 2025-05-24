package io.github.luchersol.processors.methods.handlers.single.input;

import java.lang.reflect.Method;

import javax.swing.event.PopupMenuListener;

import io.github.luchersol.annotations.methods.handlers.single.input.PopupMenuListenerHandler;
import io.github.luchersol.common.abstractClasses.AbstractListenerHandlerProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.common.exceptions.LogException;

@JProcessor
public class PopupMenuListenerHandlerProcessor
        extends AbstractListenerHandlerProcessor<PopupMenuListenerHandler, PopupMenuListener> {

    @Override
    public void process(Method method, Object object, PopupMenuListenerHandler annotation) throws LogException {
        process(method, object, annotation, "addPopupMenuListener");
    }

}
