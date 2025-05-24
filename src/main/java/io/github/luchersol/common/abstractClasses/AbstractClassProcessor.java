package io.github.luchersol.common.abstractClasses;

import java.lang.annotation.Annotation;

import io.github.luchersol.common.exceptions.LogException;
import io.github.luchersol.common.exceptions.WarningException;
import io.github.luchersol.common.interfaces.ClassProcessorInterface;

public abstract class AbstractClassProcessor<T extends Annotation> extends AbstractProcessor
        implements ClassProcessorInterface {

    public abstract void process(Class<?> clazz, Object object, T annotation) throws LogException;

    @Override
    public void process(Class<?> clazz, Object object) {
        try {
            if (clazz.isAnnotationPresent(getAnnotationClass())) {
                T annotation = clazz.getAnnotation(getAnnotationClass());
                process(clazz, object, annotation);
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
