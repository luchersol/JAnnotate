package com.jannotate.processors.mixed.fields_classes;

import java.awt.Dimension;
import java.lang.reflect.Field;

import com.jannotate.annotations.mixed.fields_classes.SetSize;
import com.jannotate.common.abstractClasses.AbstractFieldAndClassProcessor;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.common.exceptions.SevereException;

@JProcessor
public class SetSizeProcessor extends AbstractFieldAndClassProcessor<SetSize> {

    @Override
    protected void process(Field field, Object object, SetSize annotation) throws SevereException {
        try {
            Dimension dimension = new Dimension(annotation.width(), annotation.heigth());
            processMethodInField(field, object, "setPreferredSize", dimension, Dimension.class);
        } catch (Exception e) {
            throw new SevereException(e);
        }
    }

    @Override
    protected void process(Class<?> clazz, Object object, SetSize annotation) throws SevereException {
        try {
            processMethodInClass(clazz, object, "setSize", new Object[] { annotation.width(), annotation.heigth() },
                    int.class, int.class);
        } catch (Exception e) {
            throw new SevereException(e);
        }
    }

}
