package com.jannotate.processors.mixed.fields_classes.file_chooser;

import java.lang.reflect.Field;

import com.jannotate.annotations.mixed.fields_classes.file_chooser.SetFileSelectionMode;
import com.jannotate.common.abstractClasses.AbstractFieldAndClassProcessor;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.common.exceptions.LogException;

@JProcessor
public class SetFileSelectionModeProcessor extends AbstractFieldAndClassProcessor<SetFileSelectionMode> {

    @Override
    protected void process(Field field, Object object, SetFileSelectionMode annotation) throws LogException {
        processMethodInField(field, object, "setFileSelectionMode", annotation.value(), int.class);
    }

    @Override
    protected void process(Class<?> clazz, Object object, SetFileSelectionMode annotation) throws LogException {
        processMethodInClass(clazz, object, "setFileSelectionMode", annotation.value(), int.class);
    }

}
