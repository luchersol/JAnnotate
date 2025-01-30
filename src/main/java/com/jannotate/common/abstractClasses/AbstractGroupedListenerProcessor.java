package com.jannotate.common.abstractClasses;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class AbstractGroupedListenerProcessor<P extends AbstractListenerProcessor<S>, S extends Annotation, G extends Annotation>
        extends AbstractFieldProcessor<G> {

    @SuppressWarnings("unchecked")
    public Class<P> getProcessorClass() {
        return (Class<P>) getGenericClass(0);
    };

    @SuppressWarnings("unchecked")
    public Class<S> getAnnotationSingleClass() {
        return (Class<S>) getGenericClass(1);
    };

    @SuppressWarnings("unchecked")
    public Class<G> getAnnotationGroupClass() {
        return (Class<G>) getGenericClass(2);
    };

    private Class<?> getGenericClass(int index) {
        Type superclass = getClass().getGenericSuperclass();
        if (superclass instanceof ParameterizedType) {
            Type[] typeArguments = ((ParameterizedType) superclass).getActualTypeArguments();
            if (index >= 0 && index < typeArguments.length) {
                if (typeArguments[index] instanceof Class<?>) {
                    return (Class<?>) typeArguments[index];
                }
            }
        }
        return null;
    }

    public void process(Field field, Object object) {
        if (field.isAnnotationPresent(getAnnotationGroupClass())) {
            G groupAnnotations = field.getAnnotation(getAnnotationGroupClass());
            process(field, object, groupAnnotations);
        }
    }

    @SuppressWarnings("unchecked")
    public void process(Field field, Object object, G annotation) {
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
            e.printStackTrace();
        }
    }

}