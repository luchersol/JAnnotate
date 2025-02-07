package com.jannotate.processors.mixed.fields_classes;

import java.awt.Color;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.jannotate.annotations.mixed.fields_classes.SetText;
import com.jannotate.common.abstractClasses.AbstractFieldAndClassProcessor;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.common.exceptions.SevereException;

@JProcessor
public class SetTextProcessor extends AbstractFieldAndClassProcessor<SetText> {

    @Override
    public void process(Field field, Object object, SetText annotation) throws SevereException {
        try {
            Object value = getField(field, object);
            if (value != null) {
                Class<?> clazz = value.getClass();

                Method setTextMethod = getMethod(clazz, "setText", String.class);
                Method setForegroundMethod = getMethod(clazz, "setForeground", Color.class);

                setTextMethod.invoke(value, annotation.value());

                Color color = annotation.color().getColor();
                if (color == null) {
                    color = new Color(annotation.red(), annotation.green(), annotation.blue());
                }
                setForegroundMethod.invoke(value, color);

            }
        } catch (Exception e) {
            SevereException.throw_exception(e);
        }

    }

    @Override
    public void process(Class<?> clazz, Object object, SetText annotation) throws SevereException {
        try {
            List<String> errorMessages = new ArrayList<>();

            Method setTextMethod = null;
            try {
                setTextMethod = getMethod(clazz, "setText", String.class);
            } catch (NoSuchMethodException e) {
                errorMessages.add(e.getMessage());
            }

            Method setForegroundMethod = null;
            try {
                setForegroundMethod = getMethod(clazz, "setForeground", Color.class);
            } catch (NoSuchMethodException e) {
                errorMessages.add(e.getMessage());
            }

            if (setTextMethod != null) {
                setTextMethod.invoke(object, annotation.value());
            }

            if (setForegroundMethod != null) {
                Color color = annotation.color().getColor();
                if (color == null)
                    color = new Color(annotation.red(), annotation.green(), annotation.blue());
                setForegroundMethod.invoke(object, color);
            }

            if (!errorMessages.isEmpty()) {
                throw new SevereException(String.join("\n", errorMessages));
            }

        } catch (Exception e) {
            SevereException.throw_exception(e);
        }

    }

}
