package com.jannotate.common.abstractClasses;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;

import com.jannotate.common.interfaces.MethodProcessorInterface;

public abstract class AbstractMethodProccessor<T extends Annotation> extends AbstractProcessor
        implements MethodProcessorInterface {

    public abstract void process(Method method, Object object, T annotation);

    @Override
    public void process(Method method, Object object) {
        if (method.isAnnotationPresent(getAnnotationClass())) {
            method.setAccessible(true);
            T annotation = method.getAnnotation(getAnnotationClass());
            process(method, object, annotation);
        }
    }

    @SuppressWarnings("unchecked")
    private Class<T> getAnnotationClass() {
        ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
        return (Class<T>) parameterizedType.getActualTypeArguments()[0];
    }
}
