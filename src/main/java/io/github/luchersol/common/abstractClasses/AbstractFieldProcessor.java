package io.github.luchersol.common.abstractClasses;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import io.github.luchersol.common.exceptions.LogException;
import io.github.luchersol.common.exceptions.WarningException;
import io.github.luchersol.common.interfaces.FieldProcessorInterface;

public abstract class AbstractFieldProcessor<T extends Annotation> extends AbstractProcessor
        implements FieldProcessorInterface {

    public abstract void process(Field field, Object object, T annotation) throws LogException;

    @Override
    public void process(Field field, Object object) {
        try {
            if (field.isAnnotationPresent(getAnnotationClass())) {
                field.setAccessible(true);
                T annotation = field.getAnnotation(getAnnotationClass());
                process(field, object, annotation);
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
