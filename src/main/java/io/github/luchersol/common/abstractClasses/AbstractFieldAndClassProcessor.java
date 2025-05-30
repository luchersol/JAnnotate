package io.github.luchersol.common.abstractClasses;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import io.github.luchersol.common.exceptions.LogException;
import io.github.luchersol.common.exceptions.WarningException;
import io.github.luchersol.common.interfaces.FieldAndClassProcessorInterface;

public abstract class AbstractFieldAndClassProcessor<T extends Annotation> extends AbstractProcessor
        implements FieldAndClassProcessorInterface {

    public abstract void process(Field field, Object object, T annotation) throws LogException;

    public abstract void process(Class<?> clazz, Object object, T annotation) throws LogException;

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
