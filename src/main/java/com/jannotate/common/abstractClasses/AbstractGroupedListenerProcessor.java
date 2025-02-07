package com.jannotate.common.abstractClasses;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.jannotate.common.exceptions.SevereException;

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
        } catch (SevereException e) {
            logger.severe(e.getMessage());
        }

    }

    @SuppressWarnings("unchecked")
    public void process(Field field, Object object, G annotation) throws SevereException {
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
        } catch (Exception e) {
            SevereException.throw_exception(e);
        }
    }

}