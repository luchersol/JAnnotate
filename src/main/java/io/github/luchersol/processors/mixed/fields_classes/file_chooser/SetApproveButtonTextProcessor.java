package io.github.luchersol.processors.mixed.fields_classes.file_chooser;

import java.lang.reflect.Field;

import io.github.luchersol.annotations.mixed.fields_classes.file_chooser.SetApproveButtonText;
import io.github.luchersol.common.abstractClasses.AbstractFieldAndClassProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.common.exceptions.LogException;

@JProcessor
public class SetApproveButtonTextProcessor extends AbstractFieldAndClassProcessor<SetApproveButtonText> {

    @Override
    public void process(Field field, Object object, SetApproveButtonText annotation) throws LogException {
        processMethodInField(field, object, "setApproveButtonText", annotation.value(), String.class);
    }

    @Override
    public void process(Class<?> clazz, Object object, SetApproveButtonText annotation) throws LogException {
        processMethodInClass(clazz, object, "setApproveButtonText", annotation.value(), String.class);
    }

}
