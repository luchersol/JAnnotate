package com.jannotate.processors.methods.handlers.single;

import java.lang.reflect.Method;
import java.util.EventListener;

import com.jannotate.annotations.methods.handlers.single.ListenerHandler;
import com.jannotate.common.abstractClasses.AbstractListenerHandlerProcessor;
import com.jannotate.common.annotations.JProcessor;

@JProcessor
public class ListenerHandlerProcessor extends AbstractListenerHandlerProcessor<ListenerHandler, EventListener> {

    @Override
    public void process(Method method, Object object, ListenerHandler annotation) {
        StringBuilder addMethod = new StringBuilder(annotation.addMethod().trim());
        if (addMethod.isEmpty()) {
            addMethod.append("add");
            addMethod.append(annotation.type().getCanonicalName());
        }
        System.out.println(addMethod);
        process(method, object, annotation, addMethod.toString(), annotation.type());
    }

}
