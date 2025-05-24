package io.github.luchersol.processors.methods.handlers.single;

import java.lang.reflect.Method;
import java.util.EventListener;

import io.github.luchersol.annotations.methods.handlers.single.ListenerHandler;
import io.github.luchersol.common.abstractClasses.AbstractListenerHandlerProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.common.exceptions.LogException;

@JProcessor
public class ListenerHandlerProcessor extends AbstractListenerHandlerProcessor<ListenerHandler, EventListener> {

    @Override
    public void process(Method method, Object object, ListenerHandler annotation) throws LogException {
        StringBuilder addMethod = new StringBuilder(annotation.addMethod().trim());
        if (addMethod.isEmpty()) {
            addMethod.append("add");
            addMethod.append(annotation.type().getSimpleName());
        }

        process(method, object, annotation, addMethod.toString(), annotation.type());
    }

}
