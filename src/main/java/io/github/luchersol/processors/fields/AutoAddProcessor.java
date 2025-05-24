package io.github.luchersol.processors.fields;

import java.awt.Container;
import java.lang.reflect.Field;

import javax.swing.JComponent;

import io.github.luchersol.annotations.fields.AutoAdd;
import io.github.luchersol.common.abstractClasses.AbstractFieldProcessor;
import io.github.luchersol.common.annotations.JProcessor;

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
