package com.jannotate.processors.methods;

import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.swing.AbstractButton;

import com.jannotate.annotations.methods.ActionListenerHandler;
import com.jannotate.common.JProcessor;
import com.jannotate.common.MethodProcessorInterface;

@JProcessor
public class ActionListenerHandlerProcessor implements MethodProcessorInterface {

    @Override
    public void process(Method method, Object object) {
        if(method.isAnnotationPresent(ActionListenerHandler.class)){
            ActionListenerHandler annotation = method.getAnnotation(ActionListenerHandler.class);
            processActionListenerHandler(method, object, annotation);
        }
    }

    public static void processActionListenerHandler(Method method, Object object, ActionListenerHandler annotation){
        String component = annotation.component();
            try {
                Field field = object.getClass().getDeclaredField(component);
                field.setAccessible(true);
                Object value = field.get(object);
                if(value instanceof AbstractButton){
                    AbstractButton abstractButton = (AbstractButton) field.get(object);
                    Object[] parametros = parseArguments(method, annotation.args());
                    ActionListener actionListener = (ActionListener) method.invoke(object, parametros);
                    abstractButton.addActionListener(actionListener);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    private static Object[] parseArguments(Method method, String[] args) throws Exception {
        // Obtener los tipos de parámetros del método
        Class<?>[] parameterTypes = method.getParameterTypes();

        // Asegurar que la cantidad de argumentos coincida
        if (parameterTypes.length != args.length) {
            throw new IllegalArgumentException("El número de argumentos no coincide con el método");
        }

        // Crear un arreglo para los parámetros convertidos
        Object[] parsedArgs = new Object[args.length];

        // Convertir cada argumento según el tipo esperado
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
