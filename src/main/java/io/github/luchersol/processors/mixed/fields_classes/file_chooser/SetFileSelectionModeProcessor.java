package io.github.luchersol.processors.mixed.fields_classes.file_chooser;

import java.lang.reflect.Field;

import io.github.luchersol.annotations.mixed.fields_classes.file_chooser.SetFileSelectionMode;
import io.github.luchersol.common.abstractClasses.AbstractFieldAndClassProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.common.exceptions.LogException;

@JProcessor
public class SetFileSelectionModeProcessor extends AbstractFieldAndClassProcessor<SetFileSelectionMode> {

    @Override
    public void process(Field field, Object object, SetFileSelectionMode annotation) throws LogException {
        processMethodInField(field, object, "setFileSelectionMode", annotation.value(), int.class);
    }

    @Override
    public void process(Class<?> clazz, Object object, SetFileSelectionMode annotation) throws LogException {
        processMethodInClass(clazz, object, "setFileSelectionMode", annotation.value(), int.class);
    }

}
