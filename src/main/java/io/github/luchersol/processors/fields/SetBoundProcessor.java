package com.jannotate.processors.fields;

import java.lang.reflect.Field;

import javax.swing.JComponent;

import com.jannotate.annotations.fields.SetBound;
import com.jannotate.common.abstractClasses.AbstractFieldProcessor;
import com.jannotate.common.annotations.JProcessor;

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
