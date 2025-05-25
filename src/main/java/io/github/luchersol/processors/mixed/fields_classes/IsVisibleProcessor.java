package io.github.luchersol.processors.mixed.fields_classes;

import java.awt.Component;
import java.lang.reflect.Field;

import io.github.luchersol.annotations.mixed.fields_classes.IsVisible;
import io.github.luchersol.common.abstractClasses.AbstractFieldAndClassProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.common.annotations.PriorityAnnotation;
import io.github.luchersol.common.exceptions.LogException;
import io.github.luchersol.common.exceptions.SevereException;

@JProcessor
@PriorityAnnotation(Integer.MAX_VALUE)
public class IsVisibleProcessor extends AbstractFieldAndClassProcessor<IsVisible> {

    @Override
    public void process(Field field, Object object, IsVisible annotation) throws LogException {
        try {
            Component component = (Component) field.get(object);
            component.setVisible(annotation.value());
        } catch (Exception e) {
            SevereException.throwException(e);
        }
    }

    @Override
    public void process(Class<?> clazz, Object object, IsVisible annotation) throws LogException {
        try {
            Component component = (Component) object;
            component.setVisible(annotation.value());
        } catch (Exception e) {
            SevereException.throwException(e);
        }
    }

}
