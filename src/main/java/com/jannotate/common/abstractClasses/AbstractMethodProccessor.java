package com.jannotate.common.abstractClasses;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import com.jannotate.common.exceptions.LogException;
import com.jannotate.common.exceptions.WarningException;
import com.jannotate.common.interfaces.MethodProcessorInterface;

public abstract class AbstractMethodProccessor<T extends Annotation> extends AbstractProcessor
        implements MethodProcessorInterface {

    public abstract void process(Method method, Object object, T annotation) throws LogException;

    @Override
    public void process(Method method, Object object) {
        try {
            if (method.isAnnotationPresent(getAnnotationClass())) {
                method.setAccessible(true);
                T annotation = method.getAnnotation(getAnnotationClass());
                process(method, object, annotation);
            }
        } catch (WarningException e) {
            logger.warning(e.getMessage());
        } catch (Exception e) {
            logger.severe(e.getMessage());
        }

    }

    @SuppressWarnings("unchecked")
    private Class<T> getAnnotationClass() {
        return (Class<T>) getAnnotationClass(getClass(), 0);
    }
}
