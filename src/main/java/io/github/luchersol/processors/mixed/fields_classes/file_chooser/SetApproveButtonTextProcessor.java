package com.jannotate.processors.mixed.fields_classes.file_chooser;

import java.lang.reflect.Field;

import com.jannotate.annotations.mixed.fields_classes.file_chooser.SetApproveButtonText;
import com.jannotate.common.abstractClasses.AbstractFieldAndClassProcessor;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.common.exceptions.LogException;

@JProcessor
public class SetApproveButtonTextProcessor extends AbstractFieldAndClassProcessor<SetApproveButtonText> {

    @Override
    protected void process(Field field, Object object, SetApproveButtonText annotation) throws LogException {
        processMethodInField(field, object, "setApproveButtonText", annotation.value(), String.class);
    }

    @Override
    protected void process(Class<?> clazz, Object object, SetApproveButtonText annotation) throws LogException {
        processMethodInClass(clazz, object, "setApproveButtonText", annotation.value(), String.class);
    }

}
