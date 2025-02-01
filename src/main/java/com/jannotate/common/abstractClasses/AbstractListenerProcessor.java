package com.jannotate.common.abstractClasses;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public abstract class AbstractListenerProcessor<T extends Annotation> extends AbstractFieldProcessor<T> {

    @Override
    public void process(Field field, Object object) {
        if (field != null && object != null && field.isAnnotationPresent(getAnnotationClass())) {
            T annotation = field.getAnnotation(getAnnotationClass());
            field.setAccessible(true);
            process(field, object, annotation);
        }
    }

    @SuppressWarnings("unchecked")
    private Class<T> getAnnotationClass() {
        return (Class<T>) getAnnotationClass(getClass(), 0);
    }

}
