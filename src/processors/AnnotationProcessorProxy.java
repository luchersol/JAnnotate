package src.processors;

import java.awt.Container;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.swing.AbstractButton;
import javax.swing.JComponent;

import src.annotations.MyFrameInterface;
import src.annotations.fields.ActionComponent;
import src.annotations.fields.ActionsComponent;
import src.annotations.fields.AutoAdd;
import src.annotations.fields.PositionComponent;
import src.annotations.fields.SizeComponent;
import src.processors.classes.AutoInstantiateFieldsProcessor;
import src.processors.classes.LayoutManagerAnnotationProcessor;
import src.processors.fields.ActionComponentProcessor;
import src.processors.fields.ActionsComponentProcessor;
import src.processors.fields.AutoAddProcessor;
import src.processors.fields.PositionComponentProcessor;
import src.processors.fields.SizeComponentProcessor;

public class AnnotationProcessorProxy implements InvocationHandler {
    private final Object target;

    public AnnotationProcessorProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        processAnnotations(target);
        return method.invoke(target);
    }

    private void processAnnotations(Object object) {
        Class<?> clazz = object.getClass();
        AutoInstantiateFieldsProcessor.process(object, clazz);
        LayoutManagerAnnotationProcessor.process(object, clazz);
        for (Field field : clazz.getDeclaredFields()) {
            SizeComponentProcessor.process(field, object);
            PositionComponentProcessor.process(field, object);
            ActionComponentProcessor.process(field, object);
            ActionsComponentProcessor.process(field, object);
            AutoAddProcessor.process((Container) object, field);
        }
    }

    public static MyFrameInterface createProxy(Object target) {
        return (MyFrameInterface) Proxy.newProxyInstance(
            target.getClass().getClassLoader(),
            new Class[]{MyFrameInterface.class},  // Cambiar a la interfaz
            new AnnotationProcessorProxy(target)
        );
    }
}