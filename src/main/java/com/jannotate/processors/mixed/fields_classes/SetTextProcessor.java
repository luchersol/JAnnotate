package com.jannotate.processors.mixed.fields_classes;

import java.awt.Color;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.jannotate.annotations.mixed.fields_classes.SetText;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.common.interfaces.FieldAndClassProccesorInterface;

@JProcessor
public class SetTextProcessor implements FieldAndClassProccesorInterface {

    @Override
    public void process(Field field, Object object) {
        if (field.isAnnotationPresent(SetText.class)) {
            SetText annotation = field.getAnnotation(SetText.class);
            field.setAccessible(true);
            try {
                Object value = field.get(object);
                if (value != null) {
                    Class<?> clazz = value.getClass();

                    Method setTextMethod = null;
                    try {
                        setTextMethod = clazz.getMethod("setText", String.class);
                    } catch (NoSuchMethodException e) {
                        System.out.println("El campo no tiene un método 'setText(String)'");
                    }

                    Method setForegroundMethod = null;
                    try {
                        setForegroundMethod = clazz.getMethod("setForeground", Color.class);
                    } catch (NoSuchMethodException e) {
                        System.out.println("El campo no tiene un método 'setForeground(Color)'");
                    }

                    if (setTextMethod != null) {
                        setTextMethod.invoke(value, annotation.value());
                    }

                    if (setForegroundMethod != null) {
                        Color color = annotation.color().getColor();
                        if (color == null) {
                            color = new Color(annotation.red(), annotation.green(), annotation.blue());
                        }
                        setForegroundMethod.invoke(value, color);
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void process(Class<?> clazz, Object object) {
        if (clazz.isAnnotationPresent(SetText.class)) {
            SetText annotation = clazz.getAnnotation(SetText.class);
            try {
                if (object != null) {
                    Method setTextMethod = null;
                    try {
                        setTextMethod = clazz.getMethod("setText", String.class);
                    } catch (NoSuchMethodException e) {
                        System.out.println("El campo no tiene un método 'setText(String)'");
                    }

                    Method setForegroundMethod = null;
                    try {
                        setForegroundMethod = clazz.getMethod("setForeground", Color.class);
                    } catch (NoSuchMethodException e) {
                        System.out.println("El campo no tiene un método 'setForeground(Color)'");
                    }

                    if (setTextMethod != null) {
                        setTextMethod.invoke(object, annotation.value());
                    }

                    if (setForegroundMethod != null) {
                        Color color = annotation.color().getColor();
                        if (color == null) {
                            color = new Color(annotation.red(), annotation.green(), annotation.blue());
                        }
                        setForegroundMethod.invoke(object, color);
                    }
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

}
