package com.jannotate.processors.mixed.fields_classes;

import java.awt.Component;
import java.lang.reflect.Field;

import com.jannotate.annotations.mixed.fields_classes.IsVisible;
import com.jannotate.common.abstractClasses.AbstractFieldAndClassProcessor;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.common.annotations.PriorityAnnotation;
import com.jannotate.common.exceptions.SevereException;

@JProcessor
@PriorityAnnotation(Integer.MAX_VALUE)
public class IsVisibleProcessor extends AbstractFieldAndClassProcessor<IsVisible> {

    @Override
    protected void process(Field field, Object object, IsVisible annotation) throws SevereException {
        try {
            Component component = (Component) field.get(object);
            component.setVisible(annotation.value());
        } catch (Exception e) {
            SevereException.throw_exception(e);
        }
    }

    @Override
    protected void process(Class<?> clazz, Object object, IsVisible annotation) throws SevereException {
        try {
            Component component = (Component) object;
            component.setVisible(annotation.value());
        } catch (Exception e) {
            SevereException.throw_exception(e);
        }
    }

}
