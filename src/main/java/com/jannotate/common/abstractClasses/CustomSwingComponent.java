package com.jannotate.common.abstractClasses;

import java.awt.Component;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;

import javax.swing.JComponent;

import com.jannotate.common.AnnotationProcessorProxy;
import com.jannotate.common.interfaces.MyFrameInterface;

public abstract class CustomSwingComponent<T extends Component> extends JComponent implements MyFrameInterface {

    protected final T instance;

    public CustomSwingComponent() {
        T instance = createInstance(getAnnotationClass());
        AnnotationProcessorProxy.createProxy(this);
        this.instance = instance;
    }

    public CustomSwingComponent(T instance) {
        AnnotationProcessorProxy.createProxy(this);
        this.instance = instance;
    }

    public T getInstance() {
        return this.instance;
    }

    @SuppressWarnings("unchecked")
    private Class<T> getAnnotationClass() {
        ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
        return (Class<T>) parameterizedType.getActualTypeArguments()[0];
    }

    private T createInstance(Class<T> clazz) {
        try {
            return clazz.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException
                | InvocationTargetException e) {
            throw new RuntimeException("No se pudo instanciar " + clazz.getName(), e);
        }
    }

    public static void run() {
        new CustomSwingComponent<JComponent>() {

        };
    }

}
