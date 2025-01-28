package com.jannotate.common.abstractClasses;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.jannotate.common.interfaces.MethodProcessorInterface;

public abstract class AbstractListenerHandlerProcessor<T extends Annotation> implements MethodProcessorInterface {
    
    protected abstract Class<T> getAnnotationClass();

    public abstract void bindSwingListenerHandler(Method method, Object object, T annotation);

    @Override
    public void process(Method method, Object object) {
        if (method != null && object != null && method.isAnnotationPresent(getAnnotationClass())) {
            T annotation = method.getAnnotation(getAnnotationClass());
            bindSwingListenerHandler(method, object, annotation);
        }
    }

    protected static Object getField(String component, Object object) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException  {
        Field field = object.getClass().getDeclaredField(component);
        field.setAccessible(true);
        return field.get(object);
    }

    protected static Method getMethodWithParameters(Class<?> clazz, String methodName, Class<?>... parameterType) {
        while (clazz != null) {
            try {
                return clazz.getDeclaredMethod(methodName, parameterType);
            } catch (NoSuchMethodException e) {
                clazz = clazz.getSuperclass();
            }
        }
        return null; // No se encontró el método
    }

    protected static Object[] parseArguments(Method method, String[] args) throws Exception {
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
