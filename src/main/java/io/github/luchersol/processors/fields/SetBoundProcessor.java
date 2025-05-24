package io.github.luchersol.processors.fields;

import java.lang.reflect.Field;

import javax.swing.JComponent;

import io.github.luchersol.annotations.fields.SetBound;
import io.github.luchersol.common.abstractClasses.AbstractFieldProcessor;
import io.github.luchersol.common.annotations.JProcessor;

@JProcessor
public class SetBoundProcessor extends AbstractFieldProcessor<SetBound> {

    @Override
    public void process(Field field, Object object, SetBound annotation) {
        try {
            JComponent jComponent = getFieldAs(field, object, JComponent.class);
            int x = annotation.x(), y = annotation.y(), width = annotation.width(), heigth = annotation.heigth();
            jComponent.setBounds(x, y, width, heigth);
        } catch (IllegalAccessException e) {
            logger.severe(e.getMessage());
        }
    }

}
