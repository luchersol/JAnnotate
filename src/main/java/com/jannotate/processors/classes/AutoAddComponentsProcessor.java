package com.jannotate.processors.classes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

import javax.swing.JFrame;

import com.jannotate.annotations.classes.AutoInstantiateFields;
import com.jannotate.common.ClassProcessor;

import java.awt.Component;

public class AutoAddComponentsProcessor implements ClassProcessor {

    @Override
    public void process(Object object, Class<?> clazz) {
        if (clazz.isAnnotationPresent(AutoInstantiateFields.class)) {
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                try {
                    field.setAccessible(true); // Asegurar acceso al campo
                    Object value = field.get(object);

                    // Si el valor es nulo o no es del tipo esperado, continuar
                    if (value == null || !Component.class.isAssignableFrom(clazz)) {
                        continue;
                    }

                    // Buscar el método "add" y llamar con el valor del campo
                    Method method = clazz.getMethod("add", Component.class);
                    method.setAccessible(true); // Asegurar acceso al método
                    method.invoke(object, value);

                } catch (Exception e) {
                    throw new RuntimeException("Error al procesar el campo: " + field.getName(), e);
                }
            }
        }
    }

}
