package io.github.luchersol.processors.methods.handlers.single.scroll;

import java.lang.reflect.Method;

import javax.swing.event.ChangeListener;

import io.github.luchersol.annotations.methods.handlers.single.scroll.ChangeListenerHandler;
import io.github.luchersol.common.abstractClasses.AbstractListenerHandlerProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.common.exceptions.LogException;

@JProcessor
public class ChangeListenerHandlerProcessor
        extends AbstractListenerHandlerProcessor<ChangeListenerHandler, ChangeListener> {

    @Override
    public void process(Method method, Object object, ChangeListenerHandler annotation) throws LogException {
        process(method, object, annotation, "addChangeListener");
    }

}
