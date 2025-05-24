package io.github.luchersol.processors.mixed.fields_classes.file_chooser;

import java.io.File;
import java.lang.reflect.Field;

import io.github.luchersol.annotations.mixed.fields_classes.file_chooser.SetCurrentDirectory;
import io.github.luchersol.common.abstractClasses.AbstractFieldAndClassProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.common.exceptions.LogException;
import io.github.luchersol.common.exceptions.WarningException;

@JProcessor
public class SetCurrentDirectoryProcessor extends AbstractFieldAndClassProcessor<SetCurrentDirectory> {

    @Override
    protected void process(Field field, Object object, SetCurrentDirectory annotation) throws LogException {
        try {
            File file = new File(annotation.value());
            processMethodInField(field, object, "setCurrentDirectory", file, File.class);
        } catch (Exception e) {
            WarningException.throwException(e);
        }

    }

    @Override
    protected void process(Class<?> clazz, Object object, SetCurrentDirectory annotation) throws LogException {
        try {
            File file = new File(annotation.value());
            processMethodInClass(clazz, object, "setCurrentDirectory", file, File.class);
        } catch (Exception e) {
            WarningException.throwException(e);
        }
    }

}
