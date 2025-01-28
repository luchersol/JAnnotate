package com.jannotate.common;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public abstract class AbstractListenerProcessor<T extends Annotation> implements FieldProcessorInterface {


    @Override
    public void process(Field field, Object object) {
        if (field != null && object != null && field.isAnnotationPresent(getAnnotationClass())) {
            T annotation = field.getAnnotation(getAnnotationClass());
            bindSwingListener(field, object, annotation);
        }
    }

    protected abstract Class<T> getAnnotationClass();

    public abstract void bindSwingListener(Field field, Object object, T annotation);

    protected static Object[] parseArguments(Method method, String[] args) throws IllegalArgumentException {
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
