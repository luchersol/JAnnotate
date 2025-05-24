package com.jannotate.processors.fields;

import java.awt.Container;
import java.lang.reflect.Field;

import javax.swing.JComponent;

import com.jannotate.annotations.fields.AutoAdd;
import com.jannotate.common.abstractClasses.AbstractFieldProcessor;
import com.jannotate.common.annotations.JProcessor;

@JProcessor
public class AutoAddProcessor extends AbstractFieldProcessor<AutoAdd> {

    public void process(Field field, Object object, AutoAdd annotation) {
        try {
            Container container = (Container) object;
            JComponent value = getFieldAs(field, object, JComponent.class);
            container.add(value);
        } catch (IllegalAccessException e) {
            logger.severe(e.getMessage());
        }
    }
}
