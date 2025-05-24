package io.github.luchersol.processors.mixed.fields_classes.file_chooser;

import java.lang.reflect.Field;

import io.github.luchersol.annotations.mixed.fields_classes.file_chooser.IsMultiSelection;
import io.github.luchersol.common.abstractClasses.AbstractFieldAndClassProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.common.exceptions.LogException;

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
