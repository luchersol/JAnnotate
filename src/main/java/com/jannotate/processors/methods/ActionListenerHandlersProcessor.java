package com.jannotate.processors.methods;

import java.lang.reflect.Method;

import com.jannotate.annotations.methods.ActionListenerHandler;
import com.jannotate.annotations.methods.ActionListenerHandlers;
import com.jannotate.common.JProcessor;
import com.jannotate.common.MethodProcessorInterface;

@JProcessor
public class ActionListenerHandlersProcessor implements MethodProcessorInterface{

    @Override
    public void process(Method method, Object object) {
        if(method.isAnnotationPresent(ActionListenerHandlers.class)){
            ActionListenerHandlers annotations = method.getAnnotation(ActionListenerHandlers.class);
            for (ActionListenerHandler annotation : annotations.actions()) {
                ActionListenerHandlerProcessor.processActionListenerHandler(method, object, annotation);
            }
        }
    }
    
}
