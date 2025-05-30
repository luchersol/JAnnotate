package io.github.luchersol.processors.classes;

import java.lang.reflect.Field;

import io.github.luchersol.annotations.classes.AutoInstantiateFields;
import io.github.luchersol.common.abstractClasses.AbstractClassProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.common.annotations.PriorityAnnotation;
import io.github.luchersol.common.exceptions.LogException;
import io.github.luchersol.common.exceptions.SevereException;

@JProcessor
@PriorityAnnotation
public class AutoInstantiateFieldsProcessor extends AbstractClassProcessor<AutoInstantiateFields> {

    @Override
    public void process(Class<?> clazz, Object object, AutoInstantiateFields annotation) throws LogException {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);

                // Verificar si el campo es null
                if (field.get(object) == null) {
                    Class<?> fieldType = field.getType();
                    Object instance = fieldType.getDeclaredConstructor().newInstance();
                    field.set(object, instance);
                    if (annotation.recursive()) {
                        process(field.getType(), field.get(object), annotation);
                    }
                }
            } catch (Exception e) {
                SevereException.throwException("No se pudo inicializar el campo: " + field.getName());
            }
        }
    }

}
