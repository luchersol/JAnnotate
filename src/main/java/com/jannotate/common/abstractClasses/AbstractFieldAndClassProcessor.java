package com.jannotate.common.abstractClasses;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import com.jannotate.common.interfaces.FieldAndClassProccesorInterface;

public abstract class AbstractFieldAndClassProcessor<T extends Annotation> extends AbstractProcessor
        implements FieldAndClassProccesorInterface {

    protected abstract void process(Field field, Object object, T annotation);

    protected abstract void process(Class<?> clazz, Object object, T annotation);

    @Override
    public void process(Field field, Object object) {
        if (field.isAnnotationPresent(getAnnotationClass())) {
            T annotation = field.getAnnotation(getAnnotationClass());
            process(field, object, annotation);
        }
    }

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
