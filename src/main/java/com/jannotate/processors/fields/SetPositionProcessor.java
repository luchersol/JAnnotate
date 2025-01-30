package com.jannotate.processors.fields;

import java.lang.reflect.Field;

import javax.swing.JComponent;

import com.jannotate.annotations.fields.SetPosition;
import com.jannotate.common.abstractClasses.AbstractFieldProcessor;
import com.jannotate.common.annotations.JProcessor;

@JProcessor
public class SetPositionProcessor extends AbstractFieldProcessor<SetPosition> {

    public void process(Field field, Object object, SetPosition annotation) {
        try {
            JComponent jComponent = getFieldAs(field, object, JComponent.class);
            int x = annotation.x(), y = annotation.y(), width = jComponent.getWidth(), heigth = jComponent.getHeight();
            jComponent.setBounds(x, y, width, heigth);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
