package io.github.luchersol.processors.fields;

import java.lang.reflect.Field;

import javax.swing.JComponent;

import io.github.luchersol.annotations.fields.SetPosition;
import io.github.luchersol.common.abstractClasses.AbstractFieldProcessor;
import io.github.luchersol.common.annotations.JProcessor;

@JProcessor
public class SetPositionProcessor extends AbstractFieldProcessor<SetPosition> {

    public void process(Field field, Object object, SetPosition annotation) {
        try {
            JComponent jComponent = getFieldAs(field, object, JComponent.class);
            int x = annotation.x(), y = annotation.y(), width = jComponent.getWidth(), heigth = jComponent.getHeight();
            jComponent.setBounds(x, y, width, heigth);
        } catch (IllegalAccessException e) {
            logger.severe(e.getMessage());
        }
    }

}
