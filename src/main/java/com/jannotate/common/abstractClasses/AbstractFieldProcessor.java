package com.jannotate.common.abstractClasses;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;

import com.jannotate.common.interfaces.FieldProcessorInterface;

public abstract class AbstractFieldProcessor<T extends Annotation> extends AbstractProcessor
        implements FieldProcessorInterface {

    public abstract void process(Field field, Object object, T annotation);

    @Override
    public void process(Field field, Object object) {
        if (field.isAnnotationPresent(getAnnotationClass())) {
            field.setAccessible(true);
            T annotation = field.getAnnotation(getAnnotationClass());
            process(field, object, annotation);
        }
    }

    @SuppressWarnings("unchecked")
    private Class<T> getAnnotationClass() {
        ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
        return (Class<T>) parameterizedType.getActualTypeArguments()[0];
    }

}
