package com.jannotate.common.abstractClasses;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.EventListener;

import com.jannotate.common.exceptions.LogException;
import com.jannotate.common.exceptions.SevereException;

public abstract class AbstractListenerHandlerProcessor<T extends Annotation, L extends EventListener>
        extends AbstractMethodProccessor<T> {

    public void process(Method method, Object object, T annotation, String addMethodName) throws LogException {
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
            SevereException.throwException(e);
        }
    }

    public <E extends EventListener> void process(Method method, Object object, T annotation, String addMethodName,
            Class<E> clazzEventListener) throws LogException {
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
            SevereException.throwException(e);
        }
    }

    @SuppressWarnings("unchecked")
    private Class<L> getEventListenerClass() {
        return (Class<L>) getAnnotationClass(getClass(), 1);
    }
}
