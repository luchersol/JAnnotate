package io.github.luchersol.common.abstractClasses;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.EventListener;

import io.github.luchersol.common.exceptions.LogException;
import io.github.luchersol.common.exceptions.SevereException;
import io.github.luchersol.common.exceptions.WarningException;

public abstract class AbstractGroupedListenerHandlerProcessor<P extends AbstractListenerHandlerProcessor<S, ? extends EventListener>, S extends Annotation, G extends Annotation>
        extends AbstractMethodProccessor<G> {

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

    public void process(Method method, Object object) {
        try {
            if (method.isAnnotationPresent(getAnnotationGroupClass())) {
                G groupAnnotations = method.getAnnotation(getAnnotationGroupClass());
                process(method, object, groupAnnotations);
            }
        } catch (WarningException e) {
            logger.warning(e.getMessage());
        } catch (Exception e) {
            logger.severe(e.getMessage());
        }

    }

    @SuppressWarnings("unchecked")
    public void process(Method method, Object object, G annotation) throws LogException {
        try {
            Method value = annotation.annotationType().getMethod("value");
            Object result = value.invoke(annotation);
            if (result instanceof Object[]) {
                S[] actions = (S[]) result;
                for (S actionComponent : actions) {
                    P instance = getProcessorClass().getDeclaredConstructor().newInstance();
                    instance.process(method, object, actionComponent);
                }
            }
        } catch (Exception e) {
            new SevereException(e.getMessage());
        }
    }

}
