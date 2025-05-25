package io.github.luchersol.processors.mixed.fields_classes;

import java.awt.Component;
import java.lang.reflect.Field;

import javax.swing.JScrollPane;

import io.github.luchersol.annotations.mixed.fields_classes.SetScroll;
import io.github.luchersol.common.abstractClasses.AbstractFieldAndClassProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.common.exceptions.LogException;
import io.github.luchersol.common.exceptions.SevereException;

@JProcessor
public class SetScrollProcessor extends AbstractFieldAndClassProcessor<SetScroll> {

    @Override
    public void process(Field field, Object object, SetScroll annotation) throws LogException {
        try {
            Component component = getFieldAs(field, object, Component.class);
            JScrollPane scrollPane = getFieldAs(annotation.value(), object, JScrollPane.class);
            scrollPane.setViewportView(component);
        } catch (Exception e) {
            SevereException.throwException(e);
        }
    }

    @Override
    public void process(Class<?> clazz, Object object, SetScroll annotation) throws LogException {
        try {
            Component component = Component.class.cast(object);
            JScrollPane scrollPane = getFieldAs(annotation.value(), object, JScrollPane.class);
            scrollPane.setViewportView(component);
        } catch (Exception e) {
            SevereException.throwException(e);
        }
    }

}
