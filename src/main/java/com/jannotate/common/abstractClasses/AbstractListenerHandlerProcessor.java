package com.jannotate.common.abstractClasses;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EventListener;

public abstract class AbstractListenerHandlerProcessor<T extends Annotation, L extends EventListener>
        extends AbstractMethodProccessor<T> {

    public void process(Method method, Object object, T annotation, String addMethodName) {
        try {
            Method valueMethod = annotation.getClass().getDeclaredMethod("value");
            Method argsMethod = annotation.getClass().getDeclaredMethod("args");
            String value = valueMethod.invoke(annotation).toString();
            Object component = value.isBlank() ? object : getFieldAs(value, object, Object.class);
            Object[] parametros = parseArguments(method, (String[]) argsMethod.invoke(annotation));
            Method addMethod = getMethod(component.getClass(), addMethodName, getEventListenerClass());
            L listener = getEventListenerClass().cast(method.invoke(object, parametros));
            addMethod.invoke(component, listener);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public <E extends EventListener> void process(Method method, Object object, T annotation, String addMethodName,
            Class<E> clazzEventListener) {
        try {
            Method valueMethod = annotation.getClass().getDeclaredMethod("value");
            Method argsMethod = annotation.getClass().getDeclaredMethod("args");
            String value = valueMethod.invoke(annotation).toString();
            Object component = value.isBlank() ? object : getFieldAs(value, object, Object.class);
            Object[] parametros = parseArguments(method, (String[]) argsMethod.invoke(annotation));
            Method addMethod = getMethod(component.getClass(), addMethodName, clazzEventListener);
            E listener = clazzEventListener.cast(method.invoke(object, parametros));
            addMethod.invoke(component, listener);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Class<?> getGenericTypeClass(int index) {
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

    @SuppressWarnings("unchecked")
    private Class<L> getEventListenerClass() {
        return (Class<L>) getAnnotationClass(getClass(), 1);
    }
}
