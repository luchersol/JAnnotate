package com.jannotate.processors.mixed.fields_classes;

import java.lang.reflect.Field;

import javax.swing.JFrame;

import com.jannotate.annotations.mixed.fields_classes.SetTitle;
import com.jannotate.common.abstractClasses.AbstractFieldAndClassProcessor;
import com.jannotate.common.annotations.JProcessor;

@JProcessor
public class SetTitleProcessor extends AbstractFieldAndClassProcessor<SetTitle> {

    @Override
    protected void process(Field field, Object object, SetTitle annotation) {
        try {
            JFrame frame = getFieldAs(field, object, JFrame.class);
            frame.setTitle(annotation.value());
        } catch (Exception e) {
            logger.severe(e.getMessage());
        }
    }

    @Override
    protected void process(Class<?> clazz, Object object, SetTitle annotation) {
        try {
            JFrame frame = (JFrame) object;
            frame.setTitle(annotation.value());
        } catch (Exception e) {
            logger.severe(e.getMessage());
        }

    }

}
