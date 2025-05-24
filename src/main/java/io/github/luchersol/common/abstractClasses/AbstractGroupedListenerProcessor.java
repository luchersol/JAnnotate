package io.github.luchersol.common.abstractClasses;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import io.github.luchersol.common.exceptions.LogException;
import io.github.luchersol.common.exceptions.SevereException;
import io.github.luchersol.common.exceptions.WarningException;

public abstract class AbstractGroupedListenerProcessor<P extends AbstractListenerProcessor<S>, S extends Annotation, G extends Annotation>
        extends AbstractFieldProcessor<G> {

    @SuppressWarnings("unchecked")
    public Class<P> getProcessorClass() {
        return (Class<P>) getAnnotationClass(getClass(), 0);
    };

    @SuppressWarnings("unchecked")
    public Class<S> getAnnotationSingleClass() {
        return (Class<S>) getAnnotationClass(getClass(), 1);
    };

    @SuppressWarnings("unchecked")
    public Class<G> getAnnotationGroupClass() {
        return (Class<G>) getAnnotationClass(getClass(), 2);
    };

    public void process(Field field, Object object) {
        try {
            if (field.isAnnotationPresent(getAnnotationGroupClass())) {
                G groupAnnotations = field.getAnnotation(getAnnotationGroupClass());
                process(field, object, groupAnnotations);
            }
        } catch (WarningException e) {
            logger.warning(e.getMessage());
        } catch (Exception e) {
            logger.severe(e.getMessage());
        }

    }

    @SuppressWarnings("unchecked")
    public void process(Field field, Object object, G annotation) throws LogException {
        try {
            Method value = annotation.annotationType().getMethod("value");
            Object result = value.invoke(annotation);
            if (result instanceof Object[]) {
                S[] actions = (S[]) result;
                for (S actionComponent : actions) {
                    P instance = getProcessorClass().getDeclaredConstructor().newInstance();
                    instance.process(field, object, actionComponent);
                }
            }
        } catch (WarningException e) {
            logger.warning(e.getMessage());
        } catch (Exception e) {
            SevereException.throwException(e);
        }
    }

}
