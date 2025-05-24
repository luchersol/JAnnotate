package com.jannotate.processors.methods.handlers.single.scroll;

import java.awt.event.AdjustmentListener;
import java.lang.reflect.Method;

import com.jannotate.annotations.methods.handlers.single.scroll.AdjustmentListenerHandler;
import com.jannotate.common.abstractClasses.AbstractListenerHandlerProcessor;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.common.exceptions.LogException;

@JProcessor
public class AdjustmentListenerHandlerProcessor
        extends AbstractListenerHandlerProcessor<AdjustmentListenerHandler, AdjustmentListener> {

    @Override
    public void process(Method method, Object object, AdjustmentListenerHandler annotation) throws LogException {
        process(method, object, annotation, "addAdjustmentListener");
    }

}
