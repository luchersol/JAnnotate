package com.jannotate.processors.mixed.fields_classes;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.jannotate.annotations.mixed.fields_classes.SetColumns;
import com.jannotate.common.abstractClasses.AbstractFieldAndClassProcessor;
import com.jannotate.common.annotations.JProcessor;

@JProcessor
public class SetColumnsProcessor extends AbstractFieldAndClassProcessor<SetColumns> {

    @Override
    protected void process(Field field, Object object, SetColumns annotation) {
        try {
            processMethodInField(field, object, "setColumns", new Object[] { annotation.value() }, int.class);
        } catch (Exception e) {
            logger.severe(e.getMessage());
        }
    }

    @Override
    protected void process(Class<?> clazz, Object object, SetColumns annotation) {
        try {
            Method setColumnMethod = getMethod(clazz, "setColumns", int.class);
            setColumnMethod.invoke(object, annotation.value());
        } catch (NoSuchMethodException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException e) {
            logger.severe(e.getMessage());
        }
    }

}
