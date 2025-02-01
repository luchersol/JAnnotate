package com.jannotate.common.abstractClasses;

import java.lang.annotation.Annotation;

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
        return (Class<T>) getAnnotationClass(getClass(), 0);
    }

}
