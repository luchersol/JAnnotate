package io.github.luchersol.processors.mixed.fields_classes;

import java.awt.Component;
import java.lang.reflect.Field;

import io.github.luchersol.annotations.mixed.fields_classes.SetLocationRelativeTo;
import io.github.luchersol.common.abstractClasses.AbstractFieldAndClassProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.common.exceptions.LogException;
import io.github.luchersol.common.exceptions.SevereException;

@JProcessor
public class SetLocationRelativeToProcessor extends AbstractFieldAndClassProcessor<SetLocationRelativeTo> {

    @Override
    protected void process(Field field, Object object, SetLocationRelativeTo annotation) throws LogException {
        try {
            Component component = null;
            if (!annotation.value().isBlank())
                component = getFieldAs(annotation.value(), object, Component.class);
            processMethodInField(field, object, "setLocationRelativeTo", component, Component.class);
        } catch (Exception e) {
            SevereException.throwException(e);
        }
    }

    @Override
    protected void process(Class<?> clazz, Object object, SetLocationRelativeTo annotation) throws LogException {
        try {
            Component component = null;
            if (!annotation.value().isBlank())
                component = getFieldAs(annotation.value(), object, Component.class);
            processMethodInClass(clazz, object, "setLocationRelativeTo", component, Component.class);
            processMethodInClass(clazz, object, "revalidate");
            processMethodInClass(clazz, object, "repaint");
        } catch (Exception e) {
            SevereException.throwException(e);
        }
    }

}
