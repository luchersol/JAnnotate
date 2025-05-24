package io.github.luchersol.processors.methods.handlers.single.scroll;

import java.awt.event.AdjustmentListener;
import java.lang.reflect.Method;

import io.github.luchersol.annotations.methods.handlers.single.scroll.AdjustmentListenerHandler;
import io.github.luchersol.common.abstractClasses.AbstractListenerHandlerProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.common.exceptions.LogException;

@JProcessor
public class AdjustmentListenerHandlerProcessor
        extends AbstractListenerHandlerProcessor<AdjustmentListenerHandler, AdjustmentListener> {

    @Override
    public void process(Method method, Object object, AdjustmentListenerHandler annotation) throws LogException {
        process(method, object, annotation, "addAdjustmentListener");
    }

}
