package com.jannotate.common.abstractClasses;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.logging.Logger;

import com.jannotate.common.annotations.MethodAndArgs;
import com.jannotate.common.logger.CustomLogger;

public abstract class AbstractProcessor {

    protected Logger logger;

    public AbstractProcessor() {
        this.logger = CustomLogger.getLogger(this.getClass().getName());
    }

    protected Logger getLogger(Class<?> clazz) {
        return Logger.getLogger(clazz.getName());
    }

    protected static <T> T getFieldAs(Field field, Object object, Class<T> clazz)
            throws IllegalArgumentException, IllegalAccessException {
        field.setAccessible(true);
        return clazz.cast(field.get(object));
    }

    protected static Object getField(Field field, Object object)
            throws IllegalArgumentException, IllegalAccessException {
        return getFieldAs(field, object, Object.class);
    }

    protected static <T> T getFieldAs(String fieldName, Object object, Class<T> clazz)
            throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
        Field field = object.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return clazz.cast(field.get(object));
    }

    protected static Method getMethod(Class<?> clazz, String methodName, Class<?>... parameterType)
            throws NoSuchMethodException {
        String originClazzName = clazz.getSimpleName();
        while (clazz != null) {
            try {
                Method method = clazz.getDeclaredMethod(methodName, parameterType);
                method.setAccessible(true);
                return method;
            } catch (NoSuchMethodException e) {
                clazz = clazz.getSuperclass();
            }
        }
        throw new NoSuchMethodException(String.format("Method %s with params %s not found in class %s", methodName,
                Arrays.toString(parameterType), originClazzName));
    }

    protected static <T> Class<?> getAnnotationClass(Class<T> clazz, int index) {
        ParameterizedType parameterizedType = (ParameterizedType) clazz.getGenericSuperclass();
        return (Class<?>) parameterizedType.getActualTypeArguments()[index];
    }

    public static void processMethodInField(Field field, Object object, String methodName, Object[] params,
            Class<?>... parameterType) {
        try {
            Object value = getFieldAs(field, object, Object.class);
            Method method = getMethod(value.getClass(), methodName, parameterType);
            method.invoke(value, params);
        } catch (NoSuchMethodException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void processMethodInField(Field field, Object object, String methodName, Object param,
            Class<?>... parameterType) {
        processMethodInField(field, object, methodName, new Object[] { param }, parameterType);
    }

    public static void processMethodInClass(Class<?> clazz, Object object, String methodName, Object[] params,
            Class<?>... parameterType)
            throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = getMethod(clazz, methodName, parameterType);
        method.invoke(object, params);
    }

    public static void processMethodInClass(Class<?> clazz, Object object, String methodName, Object param,
            Class<?>... parameterType)
            throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        processMethodInClass(clazz, object, methodName, new Object[] { param }, parameterType);
    }

    protected static void processMethodAndArgs(MethodAndArgs methodAndArgs, Object object)
            throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (!methodAndArgs.value().isBlank()) {
            Method method = getMethod(object.getClass(), methodAndArgs.value(), methodAndArgs.type_args());
            Object[] args = parseArguments(method, methodAndArgs.args());
            method.invoke(object, args);
        }
    }

    protected static Object[] parseArguments(Method method, String[] args) {
        Class<?>[] parameterTypes = method.getParameterTypes();

        if (parameterTypes.length != args.length)
            throw new IllegalArgumentException("El número de argumentos no coincide con el método");

        Object[] parsedArgs = new Object[args.length];

        for (int i = 0; i < args.length; i++) {
            Class<?> type = parameterTypes[i];

            if (type == int.class || type == Integer.class) {
                parsedArgs[i] = Integer.parseInt(args[i]);
            } else if (type == boolean.class || type == Boolean.class) {
                parsedArgs[i] = Boolean.parseBoolean(args[i]);
            } else if (type == double.class || type == Double.class) {
                parsedArgs[i] = Double.parseDouble(args[i]);
            } else if (type == long.class || type == Long.class) {
                parsedArgs[i] = Long.parseLong(args[i]);
            } else if (type == String.class) {
                parsedArgs[i] = args[i];
            } else {
                throw new IllegalArgumentException("Tipo de parámetro no soportado: " + type.getName());
            }
        }

        return parsedArgs;
    }
}
