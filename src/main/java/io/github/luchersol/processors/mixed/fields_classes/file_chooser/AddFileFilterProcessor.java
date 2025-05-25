package io.github.luchersol.processors.mixed.fields_classes.file_chooser;

import java.lang.reflect.Field;

import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import io.github.luchersol.annotations.mixed.fields_classes.file_chooser.AddFileFilter;
import io.github.luchersol.common.abstractClasses.AbstractFieldAndClassProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.common.exceptions.LogException;

@JProcessor
public class AddFileFilterProcessor extends AbstractFieldAndClassProcessor<AddFileFilter> {

    @Override
    public void process(Field field, Object object, AddFileFilter annotation) throws LogException {
        FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter(annotation.description(),
                annotation.value());
        processMethodInField(field, object, "setFileFilter", fileNameExtensionFilter,
                FileFilter.class);
    }

    @Override
    public void process(Class<?> clazz, Object object, AddFileFilter annotation) throws LogException {
        FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter(annotation.description(),
                annotation.value());
        processMethodInClass(clazz, object, "setFileFilter", fileNameExtensionFilter,
                FileFilter.class);
    }

}
