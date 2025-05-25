package io.github.luchersol.processors.mixed.fields_classes;

import java.awt.Component;
import java.awt.Font;
import java.lang.reflect.Field;

import io.github.luchersol.annotations.mixed.fields_classes.SetFont;
import io.github.luchersol.common.abstractClasses.AbstractFieldAndClassProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.common.exceptions.LogException;
import io.github.luchersol.common.exceptions.SevereException;

@JProcessor
public class SetFontProcessor extends AbstractFieldAndClassProcessor<SetFont> {

    @Override
    protected void process(Field field, Object object, SetFont annotation) throws LogException {
        try {
            Component component = getFieldAs(field, object, Component.class);
            Font f = new Font(annotation.name(), annotation.style(), annotation.size());
            component.setFont(f);
        } catch (Exception e) {
            SevereException.throwException(e);
        }
    }

    @Override
    protected void process(Class<?> clazz, Object object, SetFont annotation) throws LogException {
        try {
            Component component = Component.class.cast(object);
            Font f = new Font(annotation.name(), annotation.style(), annotation.size());
            component.setFont(f);
        } catch (Exception e) {
            SevereException.throwException(e);
        }
    }

}
