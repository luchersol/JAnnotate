package com.jannotate.common.abstractClasses;

import java.awt.Component;
import java.lang.reflect.ParameterizedType;

import javax.swing.JComponent;

import com.jannotate.common.AnnotationProcessorProxy;
import com.jannotate.common.interfaces.MyFrameInterface;

public abstract class CustomSwingComponent<T extends Component> extends JComponent implements MyFrameInterface {

    protected final T instance;

    public CustomSwingComponent() {
        this.instance = createInstance(getAnnotationClass());
        AnnotationProcessorProxy.createProxy(this);
    }

    public CustomSwingComponent(T instance) {
        this.instance = instance;
        AnnotationProcessorProxy.createProxy(this);
    }

    public T getInstance() {
        return this.instance;
    }

    @SuppressWarnings("unchecked")
    private Class<T> getAnnotationClass() {
        if (!(getClass().getGenericSuperclass() instanceof ParameterizedType)) {
            throw new IllegalStateException("No se pudo obtener la clase genérica.");
        }
        ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
        return (Class<T>) parameterizedType.getActualTypeArguments()[0];
    }

    private T createInstance(Class<T> clazz) {
        try {
            return clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("No se pudo instanciar " + clazz.getName(), e);
        }
    }

}
