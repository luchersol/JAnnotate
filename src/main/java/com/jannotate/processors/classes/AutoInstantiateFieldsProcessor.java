package com.jannotate.processors.classes;

import java.lang.reflect.Field;

import com.jannotate.annotations.classes.AutoInstantiateFields;
import com.jannotate.common.abstractClasses.AbstractClassProcessor;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.common.annotations.PriorityAnnotation;
import com.jannotate.common.exceptions.LogException;
import com.jannotate.common.exceptions.SevereException;

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
                SevereException.throw_exception("No se pudo inicializar el campo: " + field.getName());
            }
        }
    }

}
