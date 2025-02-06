package com.jannotate.common.abstractClasses;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import com.jannotate.common.exceptions.SevereException;
import com.jannotate.common.interfaces.FieldProcessorInterface;

public abstract class AbstractFieldProcessor<T extends Annotation> extends AbstractProcessor
        implements FieldProcessorInterface {

    public abstract void process(Field field, Object object, T annotation) throws SevereException;

    @Override
    public void process(Field field, Object object) {
        try {
            if (field.isAnnotationPresent(getAnnotationClass())) {
                field.setAccessible(true);
                T annotation = field.getAnnotation(getAnnotationClass());
                process(field, object, annotation);
            }
        } catch (SevereException e) {
            logger.severe(e.getMessage());
        }

    }

    @SuppressWarnings("unchecked")
    private Class<T> getAnnotationClass() {
        return (Class<T>) getAnnotationClass(getClass(), 0);
    }

}
