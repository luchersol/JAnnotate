package com.jannotate.common;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.reflections.Reflections;

import com.jannotate.common.annotations.JProcessor;
import com.jannotate.common.annotations.PriorityAnnotation;
import com.jannotate.common.interfaces.AbstractProcessorInterface;
import com.jannotate.common.interfaces.ClassProcessorInterface;
import com.jannotate.common.interfaces.FieldProcessorInterface;
import com.jannotate.common.interfaces.MethodProcessorInterface;
import com.jannotate.common.interfaces.MyFrameInterface;

public class AnnotationProcessorProxy implements InvocationHandler {
    private final Object target;

    public AnnotationProcessorProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        processAnnotations(target);
        return proxy;
    }

    private static final Set<Class<? extends ClassProcessorInterface>> classProcessors;
    private static final Set<Class<? extends FieldProcessorInterface>> fieldProcessors;
    private static final Set<Class<? extends MethodProcessorInterface>> methodProcessors;

    static {
        classProcessors = doReflections("com.jannotate.processors.classes", ClassProcessorInterface.class);
        fieldProcessors = doReflections("com.jannotate.processors.fields", FieldProcessorInterface.class);
        methodProcessors = doReflections("com.jannotate.processors.methods", MethodProcessorInterface.class);
    }

    @SuppressWarnings("unchecked")
    private static <T extends AbstractProcessorInterface> Set<Class<? extends T>> doReflections(String path, Class<T> clazz) {
        Set<Class<?>> annotatedClasses = new Reflections(path).getTypesAnnotatedWith(JProcessor.class);
        return annotatedClasses.stream()
                .filter(c -> clazz.isAssignableFrom(c)) 
                .map(c -> (Class<? extends T>) c)
                .collect(Collectors.toSet());
    }

    public static List<Class<? extends ClassProcessorInterface>> getClassProcessors() {
        return getProcessors(classProcessors);
    }

    public static List<Class<? extends FieldProcessorInterface>> getFieldProcessors() {
        return getProcessors(fieldProcessors);
    }

    public static List<Class<? extends MethodProcessorInterface>> getMethodProcessors() {
        return getProcessors(methodProcessors);
    }

    public static <T extends AbstractProcessorInterface> List<Class<? extends T>> getProcessors(Set<Class<? extends T>> processors) {
        return processors.stream()
            .sorted(Comparator.comparingInt((Class<? extends T> cls) -> {
                PriorityAnnotation annotation = cls.getAnnotation(PriorityAnnotation.class);
                return annotation != null ? annotation.value() : Integer.MAX_VALUE;
            }).thenComparing((Class<? extends T> cls) -> {
                PriorityAnnotation annotation = cls.getAnnotation(PriorityAnnotation.class);
                // Opcional: puedes definir cómo ordenar por `annotations` si tiene múltiples valores
                return annotation != null && annotation.annotations().length > 0
                    ? annotation.annotations()[0].getName() // Ordena por el nombre de la primera clase en la lista
                    : ""; // Usa un valor por defecto si no hay anotaciones
            }))
            .collect(Collectors.toList());
    }

    private static final Map<Class<? extends ClassProcessorInterface>, Method> classProcessorMethods = new HashMap<>();
    private static final Map<Class<? extends FieldProcessorInterface>, Method> fieldProcessorMethods = new HashMap<>();
    private static final Map<Class<? extends MethodProcessorInterface>, Method> methodProcessorMethods = new HashMap<>();

    private static final Map<Class<? extends ClassProcessorInterface>, Constructor<?>> classProcessorConstructors = new HashMap<>();
    private static final Map<Class<? extends FieldProcessorInterface>, Constructor<?>> fieldProcessorConstructors = new HashMap<>();
    private static final Map<Class<? extends MethodProcessorInterface>, Constructor<?>> methodProcessorConstructors = new HashMap<>();

    private static <T> Method getProcessorMethod(Map<Class<? extends T>, Method> methodMap, Class<? extends T> processorClass, Class<?> parameter1, Class<?> parameter2) {
        return methodMap.computeIfAbsent(processorClass, clazz -> {
            try {
                return clazz.getMethod("process", parameter1, parameter2);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
                return null;
            }
        });
    }
    
    private static Method getClassProcessorMethod(Class<? extends ClassProcessorInterface> processor) {
        return getProcessorMethod(classProcessorMethods, processor, Class.class, Object.class);
    }
    
    private static Method getFieldProcessorMethod(Class<? extends FieldProcessorInterface> processor) {
        return getProcessorMethod(fieldProcessorMethods, processor, Field.class, Object.class);
    }
    
    private static Method getMethodProcessorMethod(Class<? extends MethodProcessorInterface> processor) {
        return getProcessorMethod(methodProcessorMethods, processor, Method.class, Object.class);
    }
    
    private static <T> Constructor<?> getProcessorConstructor(Map<Class<? extends T>, Constructor<?>> constructorMap, Class<? extends T> processorClass) {
        return constructorMap.computeIfAbsent(processorClass, clazz -> {
            try {
                return clazz.getConstructor();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
                return null;
            }
        });
    }
    
    // Uso de la función genérica para las clases específicas
    private static Constructor<?> getClassProcessorConstructor(Class<? extends ClassProcessorInterface> processor) {
        return getProcessorConstructor(classProcessorConstructors, processor);
    }
    
    private static Constructor<?> getFieldProcessorConstructor(Class<? extends FieldProcessorInterface> processor) {
        return getProcessorConstructor(fieldProcessorConstructors, processor);
    }
    
    private static Constructor<?> getMethodProcessorConstructor(Class<? extends MethodProcessorInterface> processor) {
        return getProcessorConstructor(methodProcessorConstructors, processor);
    }
    
    private static void processAnnotationClass(Class<?> clazz, Object object){
        for (Class<? extends ClassProcessorInterface> clazzProcessor : getClassProcessors()) {
            try {
                Method method = getClassProcessorMethod(clazzProcessor);
                Constructor<?> constructor = getClassProcessorConstructor(clazzProcessor);
                if (method != null && constructor != null) {
                    method.invoke(constructor.newInstance(), clazz, object);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    private static void processAnnotationFields(Class<?> clazz, Object object){
        for (Field field : clazz.getDeclaredFields()) {
            for (Class<? extends FieldProcessorInterface> clazzProcessor : getFieldProcessors()) {
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

    private static void processAnnotationMethods(Class<?> clazz, Object object){
        for (Method method : clazz.getDeclaredMethods()) {
            for (Class<? extends MethodProcessorInterface> clazzProcessor : getMethodProcessors()) {
                try {
                    Method innerMethod = getMethodProcessorMethod(clazzProcessor);
                    Constructor<?> constructor = getMethodProcessorConstructor(clazzProcessor);
                    if (innerMethod != null && constructor != null) {
                        innerMethod.invoke(constructor.newInstance(), method, object);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void processAnnotations(Object object) {
        Class<?> clazz = object.getClass();
        processAnnotationClass(clazz, object);
        processAnnotationFields(clazz, object);
        processAnnotationMethods(clazz, object);
    }

    public static void createProxy(Object target) {
        ((MyFrameInterface) Proxy.newProxyInstance(
            target.getClass().getClassLoader(),
            new Class[]{MyFrameInterface.class},
            new AnnotationProcessorProxy(target)
        )).applyAnnotations();
    }
}