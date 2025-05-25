package io.github.luchersol.processors.mixed.fields_classes.file_chooser;

import java.lang.reflect.Field;
import java.util.Objects;

import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import io.github.luchersol.annotations.mixed.fields_classes.file_chooser.AddFileFilter;
import io.github.luchersol.annotations.mixed.fields_classes.file_chooser.AddFileFilters;
import io.github.luchersol.common.abstractClasses.AbstractFieldAndClassProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.common.exceptions.LogException;

@JProcessor
public class AddFileFiltersProcessor extends AbstractFieldAndClassProcessor<AddFileFilters> {

    @Override
    public void process(Field field, Object object, AddFileFilters annotation) throws LogException {
        for (AddFileFilter fileFilterAnnotation : annotation.value()) {
            FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter(
                    fileFilterAnnotation.description(),
                    fileFilterAnnotation.value());
            processMethodInField(field, object, "addChoosableFileFilter", fileNameExtensionFilter,
                    FileFilter.class);
            if (Objects.equals(annotation.defaultFilter(), fileFilterAnnotation.description())) {
                processMethodInField(field, object, "setFileFilter", fileNameExtensionFilter,
                        FileFilter.class);
            }
        }
    }

    @Override
    public void process(Class<?> clazz, Object object, AddFileFilters annotation) throws LogException {
        for (AddFileFilter fileFilterAnnotation : annotation.value()) {
            FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter(
                    fileFilterAnnotation.description(),
                    fileFilterAnnotation.value());
            processMethodInClass(clazz, object, "addChoosableFileFilter", fileNameExtensionFilter,
                    FileFilter.class);
            if (Objects.equals(annotation.defaultFilter(), fileFilterAnnotation.description())) {
                processMethodInClass(clazz, object, "setFileFilter", fileNameExtensionFilter,
                        FileFilter.class);
            }
        }
    }

}
