package com.jannotate.processors.fields.listeners.single;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.swing.AbstractButton;
import javax.swing.JComponent;

import com.jannotate.annotations.fields.listeners.single.ComponentActionListener;
import com.jannotate.annotations.fields.listeners.single.ComponentKeyListener;
import com.jannotate.common.AbstractListenerProcessor;
import com.jannotate.common.FieldProcessorInterface;
import com.jannotate.common.JProcessor;
import com.jannotate.common.MethodAndArgs;

@JProcessor
public class ComponentKeyListenerProcessor extends AbstractListenerProcessor<ComponentKeyListener> {

    @Override
    protected Class<ComponentKeyListener> getAnnotationClass() {
        return ComponentKeyListener.class;
    }

    @Override
    public void bindSwingListener(Field field, Object object, ComponentKeyListener annotation) {
        field.setAccessible(true);
        try {
            Object value = field.get(object);
            if (value instanceof JComponent) {
                JComponent component = (JComponent) value;
                component.addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        try {
                            MethodAndArgs methodAndArgs = annotation.keyType();
                            Method method = object.getClass().getDeclaredMethod(methodAndArgs.method());
                            method.setAccessible(true);
                            Object[] args = parseArguments(method, methodAndArgs.args());
                            method.invoke(object, args);
                        } catch (NoSuchMethodException | SecurityException |IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {
                            e1.printStackTrace();
                        }
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                        try {
                            MethodAndArgs methodAndArgs = annotation.keyPressed();
                            Method method = object.getClass().getDeclaredMethod(methodAndArgs.method());
                            method.setAccessible(true);
                            Object[] args = parseArguments(method, methodAndArgs.args());
                            method.invoke(object, args);
                        } catch (NoSuchMethodException | SecurityException |IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {
                            e1.printStackTrace();
                        }
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                        try {
                            MethodAndArgs methodAndArgs = annotation.keyReleased();
                            Method method = object.getClass().getDeclaredMethod(methodAndArgs.method());
                            method.setAccessible(true);
                            Object[] args = parseArguments(method, methodAndArgs.args());
                            method.invoke(object, args);
                        } catch (NoSuchMethodException | SecurityException |IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {
                            e1.printStackTrace();
                        }
                    }
                    
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
