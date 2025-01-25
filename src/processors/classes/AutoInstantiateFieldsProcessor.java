package src.processors.classes;

import java.lang.reflect.Field;

import src.annotations.classes.AutoInstantiateFields;

public class AutoInstantiateFieldsProcessor {
    
    public static void process(Object object, Class<?> clazz) {
        if (clazz.isAnnotationPresent(AutoInstantiateFields.class)) {
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                try {
                    // Asegurarse de que el campo sea accesible
                    field.setAccessible(true);

                    // Verificar si el campo es null
                    if (field.get(object) == null) {
                        // Obtener el tipo del campo y crear una instancia con el constructor vacío
                        Class<?> fieldType = field.getType();
                        Object instance = fieldType.getDeclaredConstructor().newInstance();
                        field.set(object, instance);
                    }
                } catch (Exception e) {
                    // Manejar errores (por ejemplo, si no hay un constructor vacío o acceso
                    // denegado)
                    System.err.println("No se pudo inicializar el campo: " + field.getName());
                }
            }
        }
    }
}
