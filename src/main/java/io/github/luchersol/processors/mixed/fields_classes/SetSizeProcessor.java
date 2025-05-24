package io.github.luchersol.processors.mixed.fields_classes;

import java.awt.Dimension;
import java.lang.reflect.Field;

import io.github.luchersol.annotations.mixed.fields_classes.SetSize;
import io.github.luchersol.common.abstractClasses.AbstractFieldAndClassProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.common.exceptions.LogException;
import io.github.luchersol.common.exceptions.SevereException;

@JProcessor
public class SetSizeProcessor extends AbstractFieldAndClassProcessor<SetSize> {

    @Override
    protected void process(Field field, Object object, SetSize annotation) throws LogException {
        try {
            int value = annotation.value(), width = annotation.width(), heigth = annotation.heigth();
            Dimension dimension = annotation.value() == 0 ? new Dimension(width, heigth) : new Dimension(value, value);
            processMethodInField(field, object, "setPreferredSize", dimension, Dimension.class);
        } catch (Exception e) {
            SevereException.throwException(e);
        }
    }

    @Override
    protected void process(Class<?> clazz, Object object, SetSize annotation) throws LogException {
        try {
            processMethodInClass(clazz, object, "setSize", new Object[] { annotation.width(), annotation.heigth() },
                    int.class, int.class);
        } catch (Exception e) {
            SevereException.throwException(e);
        }
    }

}
