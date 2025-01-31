package com.jannotate.processors.methods.handlers.single.scroll;

import java.lang.reflect.Method;

import javax.swing.event.ChangeListener;

import com.jannotate.annotations.methods.handlers.single.scroll.ChangeListenerHandler;
import com.jannotate.common.abstractClasses.AbstractListenerHandlerProcessor;
import com.jannotate.common.annotations.JProcessor;

@JProcessor
public class ChangeListenerHandlerProcessor
        extends AbstractListenerHandlerProcessor<ChangeListenerHandler, ChangeListener> {

    @Override
    public void process(Method method, Object object, ChangeListenerHandler annotation) {
        process(method, object, annotation, "addChangeListener");
    }

}
