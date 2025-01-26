package com.jannotate.processors;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.reflections.Reflections;

import com.jannotate.annotations.MyFrameInterface;
import com.jannotate.common.ClassProcessor;
import com.jannotate.common.FieldProcessor;
import com.jannotate.common.PriorityAnnotation;

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

    private static final Set<Class<? extends ClassProcessor>> classProcessors;
    private static final Set<Class<? extends FieldProcessor>> fieldProcessors;

    static {
        Reflections classReflections = new Reflections("com.jannotate.processors.classes");
        Reflections fieldReflections = new Reflections("com.jannotate.processors.fields");

        classProcessors = classReflections.getSubTypesOf(ClassProcessor.class);
        fieldProcessors = fieldReflections.getSubTypesOf(FieldProcessor.class);
    }

    public static List<Class<? extends ClassProcessor>> getClassProcessors() {
        return classProcessors.stream()
            .sorted(Comparator.comparingInt((Class<? extends ClassProcessor> cls) -> {
                PriorityAnnotation annotation = cls.getAnnotation(PriorityAnnotation.class);
                return annotation != null ? annotation.value() : Integer.MAX_VALUE;
            }))
            .collect(Collectors.toList());
    }

    public static List<Class<? extends FieldProcessor>> getFieldProcessors() {
        return fieldProcessors.stream()
            .sorted(Comparator.comparingInt((Class<? extends FieldProcessor> cls) -> {
                PriorityAnnotation annotation = cls.getAnnotation(PriorityAnnotation.class);
                return annotation != null ? annotation.value() : Integer.MAX_VALUE;
            }))
            .collect(Collectors.toList());
    }

    private static final Map<Class<? extends ClassProcessor>, Method> classProcessorMethods = new HashMap<>();
    private static final Map<Class<? extends FieldProcessor>, Method> fieldProcessorMethods = new HashMap<>();
    private static final Map<Class<? extends ClassProcessor>, Constructor<?>> classProcessorConstructors = new HashMap<>();
    private static final Map<Class<? extends FieldProcessor>, Constructor<?>> fieldProcessorConstructors = new HashMap<>();

    private static Method getClassProcessorMethod(Class<? extends ClassProcessor> processor) {
        return classProcessorMethods.computeIfAbsent(processor, clazz -> {
            try {
                return clazz.getMethod("process", Object.class, Class.class);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
                return null;
            }
        });
    }
    
    private static Method getFieldProcessorMethod(Class<? extends FieldProcessor> processor) {
        return fieldProcessorMethods.computeIfAbsent(processor, clazz -> {
            try {
                return clazz.getMethod("process", Field.class, Object.class);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
                return null;
            }
        });
    }
    
    private static Constructor<?> getClassProcessorConstructor(Class<? extends ClassProcessor> processor) {
        return classProcessorConstructors.computeIfAbsent(processor, clazz -> {
            try {
                return clazz.getConstructor();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
                return null;
            }
        });
    }
    
    private static Constructor<?> getFieldProcessorConstructor(Class<? extends FieldProcessor> processor) {
        return fieldProcessorConstructors.computeIfAbsent(processor, clazz -> {
            try {
                return clazz.getConstructor();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
                return null;
            }
        });
    }
    

    private void processAnnotations(Object object) {
        Class<?> clazz = object.getClass();
        for (Class<? extends ClassProcessor> clazzProcessor : getClassProcessors()) {
            try {
                Method method = getClassProcessorMethod(clazzProcessor);
                Constructor<?> constructor = getClassProcessorConstructor(clazzProcessor);
                if (method != null && constructor != null) {
                    method.invoke(constructor.newInstance(), object, clazz);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for (Field field : clazz.getDeclaredFields()) {
            for (Class<? extends FieldProcessor> clazzProcessor : getFieldProcessors()) {
                try {
                    Method method = getFieldProcessorMethod(clazzProcessor);
                    Constructor<?> constructor = getFieldProcessorConstructor(clazzProcessor);
                    if (method != null && constructor != null) {
                        method.invoke(constructor.newInstance(), field, object);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
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