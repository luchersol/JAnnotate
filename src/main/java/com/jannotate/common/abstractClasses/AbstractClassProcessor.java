package com.jannotate.common.abstractClasses;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;

import com.jannotate.common.interfaces.ClassProcessorInterface;

public abstract class AbstractClassProcessor<T extends Annotation> extends AbstractProcessor
        implements ClassProcessorInterface {

    public abstract void process(Class<?> clazz, Object object, T annotation);

    @Override
    public void process(Class<?> clazz, Object object) {
        if (clazz.isAnnotationPresent(getAnnotationClass())) {
            T annotation = clazz.getAnnotation(getAnnotationClass());
            process(clazz, object, annotation);
        }
    }

    @SuppressWarnings("unchecked")
    private Class<T> getAnnotationClass() {
        ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
        return (Class<T>) parameterizedType.getActualTypeArguments()[0];
    }

}
