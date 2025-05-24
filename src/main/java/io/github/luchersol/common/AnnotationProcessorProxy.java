package io.github.luchersol.common;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.reflections.Reflections;

import io.github.luchersol.common.abstractClasses.CustomSwingComponent;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.common.annotations.PriorityAnnotation;
import io.github.luchersol.common.interfaces.AbstractProcessorInterface;
import io.github.luchersol.common.interfaces.ClassProcessorInterface;
import io.github.luchersol.common.interfaces.FieldProcessorInterface;
import io.github.luchersol.common.interfaces.MethodProcessorInterface;
import io.github.luchersol.common.interfaces.MyFrameInterface;
import io.github.luchersol.common.logger.CustomLogger;

public class AnnotationProcessorProxy implements InvocationHandler {

    private final Object target;

    private static final Logger logger = CustomLogger.getLogger(AnnotationProcessorProxy.class.getName());

    public AnnotationProcessorProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        processAnnotations(target);
        return proxy;
    }

    private static Set<Class<? extends ClassProcessorInterface>> classProcessors;
    private static Set<Class<? extends FieldProcessorInterface>> fieldProcessors;
    private static Set<Class<? extends MethodProcessorInterface>> methodProcessors;

    static {
        try {
            CustomLogger.load();
            logger.info("Loaded custom logger");
        } catch (Exception e) {
            logger.severe(e.getMessage());
        }

    }

    static {
        try {
            classProcessors = doReflections(ClassProcessorInterface.class, "io.github.luchersol.processors.classes",
                    "io.github.luchersol.processors.mixed.fields_classes");
            logger.info("Loaded class proccessors");
            fieldProcessors = doReflections(FieldProcessorInterface.class, "io.github.luchersol.processors.fields",
                    "io.github.luchersol.processors.mixed.fields_classes");
            logger.info("Loaded field proccessors");
            methodProcessors = doReflections(MethodProcessorInterface.class, "io.github.luchersol.processors.methods");
            logger.info("Loaded method proccessors");
        } catch (Exception e) {
            logger.severe(e.getMessage());
            System.exit(1);
        }

    }

    @SuppressWarnings("unchecked")
    private static <T extends AbstractProcessorInterface> Set<Class<? extends T>> doReflections(Class<T> clazz,
            String... paths) {
        Set<Class<?>> annotatedClasses = new HashSet<>();
        Arrays.stream(paths).forEach(
                path -> annotatedClasses.addAll(new Reflections(path).getTypesAnnotatedWith(JProcessor.class)));
        Set<Class<? extends T>> res = annotatedClasses.stream()
                .filter(c -> clazz.isAssignableFrom(c))
                .map(c -> (Class<? extends T>) c)
                .collect(Collectors.toSet());
        return res;
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

    public static <T extends AbstractProcessorInterface> List<Class<? extends T>> getProcessors(
            Set<Class<? extends T>> processors) {
        return processors.stream()
                .sorted(Comparator.comparingInt((Class<? extends T> cls) -> {
                    PriorityAnnotation annotation = cls.getAnnotation(PriorityAnnotation.class);
                    return annotation != null ? annotation.value() : Integer.MAX_VALUE;
                }).thenComparing((Class<? extends T> cls) -> {
                    PriorityAnnotation annotation = cls.getAnnotation(PriorityAnnotation.class);
                    return annotation != null && annotation.annotations().length > 0
                            ? annotation.annotations()[0].getName()
                            : "";
                }))
                .collect(Collectors.toList());
    }

    private static final Map<Class<? extends ClassProcessorInterface>, Method> classProcessorMethods = new HashMap<>();
    private static final Map<Class<? extends FieldProcessorInterface>, Method> fieldProcessorMethods = new HashMap<>();
    private static final Map<Class<? extends MethodProcessorInterface>, Method> methodProcessorMethods = new HashMap<>();

    private static final Map<Class<? extends ClassProcessorInterface>, Constructor<?>> classProcessorConstructors = new HashMap<>();
    private static final Map<Class<? extends FieldProcessorInterface>, Constructor<?>> fieldProcessorConstructors = new HashMap<>();
    private static final Map<Class<? extends MethodProcessorInterface>, Constructor<?>> methodProcessorConstructors = new HashMap<>();

    private static <T> Method getProcessorMethod(Map<Class<? extends T>, Method> methodMap,
            Class<? extends T> processorClass, Class<?> parameter1, Class<?> parameter2) {
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

    private static <T> Constructor<?> getProcessorConstructor(Map<Class<? extends T>, Constructor<?>> constructorMap,
            Class<? extends T> processorClass) {
        return constructorMap.computeIfAbsent(processorClass, clazz -> {
            try {
                return clazz.getConstructor();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
                return null;
            }
        });
    }

    private static Constructor<?> getClassProcessorConstructor(Class<? extends ClassProcessorInterface> processor) {
        return getProcessorConstructor(classProcessorConstructors, processor);
    }

    private static Constructor<?> getFieldProcessorConstructor(Class<? extends FieldProcessorInterface> processor) {
        return getProcessorConstructor(fieldProcessorConstructors, processor);
    }

    private static Constructor<?> getMethodProcessorConstructor(Class<? extends MethodProcessorInterface> processor) {
        return getProcessorConstructor(methodProcessorConstructors, processor);
    }

    private static void processAnnotationClass(Class<?> clazz, Object object) {
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

    private static void processAnnotationFields(Class<?> clazz, Object object) {
        for (Field field : clazz.getDeclaredFields()) {
            for (Class<? extends FieldProcessorInterface> fieldProcessor : getFieldProcessors()) {
                try {
                    Method method = getFieldProcessorMethod(fieldProcessor);
                    Constructor<?> constructor = getFieldProcessorConstructor(fieldProcessor);
                    if (method != null && constructor != null) {
                        method.invoke(constructor.newInstance(), field, object);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void processAnnotationMethods(Class<?> clazz, Object object) {
        for (Method method : clazz.getDeclaredMethods()) {
            for (Class<? extends MethodProcessorInterface> methodProcessor : getMethodProcessors()) {
                try {
                    Method innerMethod = getMethodProcessorMethod(methodProcessor);
                    Constructor<?> constructor = getMethodProcessorConstructor(methodProcessor);
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
        if (target instanceof CustomSwingComponent<?>) {
            target = ((CustomSwingComponent<?>) target).getInstance();
        }
        ((MyFrameInterface) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                new Class[] { MyFrameInterface.class },
                new AnnotationProcessorProxy(target))).applyAnnotations();
    }
}
