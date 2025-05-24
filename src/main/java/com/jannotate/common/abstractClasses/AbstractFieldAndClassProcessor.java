package com.jannotate.common.abstractClasses;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import com.jannotate.common.exceptions.LogException;
import com.jannotate.common.exceptions.WarningException;
import com.jannotate.common.interfaces.FieldAndClassProccesorInterface;

public abstract class AbstractFieldAndClassProcessor<T extends Annotation> extends AbstractProcessor
        implements FieldAndClassProccesorInterface {

    protected abstract void process(Field field, Object object, T annotation) throws LogException;

    protected abstract void process(Class<?> clazz, Object object, T annotation) throws LogException;

    @Override
    public void process(Field field, Object object) {
        try {
            if (field != null && object != null && field.isAnnotationPresent(getAnnotationClass())) {
                T annotation = field.getAnnotation(getAnnotationClass());
                field.setAccessible(true);
                process(field, object, annotation);
            }
        } catch (WarningException e) {
            logger.warning(e.getMessage());
        } catch (Exception e) {
            logger.severe(e.getMessage());
        }

    }

    @Override
    public void process(Class<?> clazz, Object object) {
        try {
            if (clazz.isAnnotationPresent(getAnnotationClass())) {
                T annotation = clazz.getAnnotation(getAnnotationClass());
                process(clazz, object, annotation);
            }
        } catch (Exception e) {
            logger.severe(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private Class<T> getAnnotationClass() {
        return (Class<T>) getAnnotationClass(getClass(), 0);
    }

}
