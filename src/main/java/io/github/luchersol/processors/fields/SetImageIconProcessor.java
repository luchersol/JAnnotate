package com.jannotate.processors.fields;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import com.jannotate.annotations.fields.SetImagenIcon;
import com.jannotate.common.abstractClasses.AbstractFieldProcessor;
import com.jannotate.common.annotations.JProcessor;

@JProcessor
public class SetImageIconProcessor extends AbstractFieldProcessor<SetImagenIcon> {

    @Override
    public void process(Field field, Object object, SetImagenIcon annotation) {
        try {
            Object value = field.get(object);
            Method method = getMethod(value.getClass(), "setIcon", Icon.class);
            method.invoke(value, new ImageIcon(annotation.value()));
        } catch (InvocationTargetException | SecurityException | IllegalArgumentException
                | IllegalAccessException | NoSuchMethodException e) {
            logger.severe(e.getMessage());
        }
    }

}
