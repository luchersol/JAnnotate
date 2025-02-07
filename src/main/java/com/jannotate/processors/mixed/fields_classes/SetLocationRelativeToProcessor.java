package com.jannotate.processors.mixed.fields_classes;

import java.awt.Component;
import java.lang.reflect.Field;

import com.jannotate.annotations.mixed.fields_classes.SetLocationRelativeTo;
import com.jannotate.common.abstractClasses.AbstractFieldAndClassProcessor;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.common.exceptions.SevereException;

@JProcessor
public class SetLocationRelativeToProcessor extends AbstractFieldAndClassProcessor<SetLocationRelativeTo> {

    @Override
    protected void process(Field field, Object object, SetLocationRelativeTo annotation) throws SevereException {
        try {
            Component component = null;
            if (!annotation.value().isBlank())
                component = getFieldAs(annotation.value(), object, Component.class);
            processMethodInField(field, object, "setLocationRelativeTo", component, Component.class);
        } catch (Exception e) {
            SevereException.throw_exception(e);
        }
    }

    @Override
    protected void process(Class<?> clazz, Object object, SetLocationRelativeTo annotation) throws SevereException {
        try {
            Component component = null;
            if (!annotation.value().isBlank())
                component = getFieldAs(annotation.value(), object, Component.class);
            processMethodInClass(clazz, object, "setLocationRelativeTo", component, Component.class);
            processMethodInClass(clazz, object, "revalidate");
            processMethodInClass(clazz, object, "repaint");
        } catch (Exception e) {
            SevereException.throw_exception(e);
        }
    }

}
