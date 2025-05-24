package com.jannotate.processors.mixed.fields_classes.file_chooser;

import java.lang.reflect.Field;
import java.util.Objects;

import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.jannotate.annotations.mixed.fields_classes.file_chooser.AddFileFilter;
import com.jannotate.annotations.mixed.fields_classes.file_chooser.AddFileFilters;
import com.jannotate.common.abstractClasses.AbstractFieldAndClassProcessor;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.common.exceptions.LogException;

@JProcessor
public class AddFileFiltersProcessor extends AbstractFieldAndClassProcessor<AddFileFilters> {

        @Override
        protected void process(Field field, Object object, AddFileFilters annotation) throws LogException {

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
        protected void process(Class<?> clazz, Object object, AddFileFilters annotation) throws LogException {
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
