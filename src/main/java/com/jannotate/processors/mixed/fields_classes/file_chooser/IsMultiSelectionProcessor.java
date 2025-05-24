package com.jannotate.processors.mixed.fields_classes.file_chooser;

import java.lang.reflect.Field;

import com.jannotate.annotations.mixed.fields_classes.file_chooser.IsMultiSelection;
import com.jannotate.common.abstractClasses.AbstractFieldAndClassProcessor;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.common.exceptions.LogException;

@JProcessor
public class IsMultiSelectionProcessor extends AbstractFieldAndClassProcessor<IsMultiSelection> {

    @Override
    protected void process(Field field, Object object, IsMultiSelection annotation) throws LogException {
        processMethodInFieldOrClass(annotation, object, "setMultiSelectionEnabled", annotation.value(), boolean.class);
    }

    @Override
    protected void process(Class<?> clazz, Object object, IsMultiSelection annotation) throws LogException {
        processMethodInClass(clazz, object, "setMultiSelectionEnabled", annotation.value(), boolean.class);
    }

}
