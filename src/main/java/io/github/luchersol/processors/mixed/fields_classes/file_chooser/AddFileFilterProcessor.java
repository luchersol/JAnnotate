package com.jannotate.processors.mixed.fields_classes.file_chooser;

import java.lang.reflect.Field;

import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.jannotate.annotations.mixed.fields_classes.file_chooser.AddFileFilter;
import com.jannotate.common.abstractClasses.AbstractFieldAndClassProcessor;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.common.exceptions.LogException;

@JProcessor
public class AddFileFilterProcessor extends AbstractFieldAndClassProcessor<AddFileFilter> {

        @Override
        protected void process(Field field, Object object, AddFileFilter annotation) throws LogException {
                FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter(annotation.description(),
                                annotation.value());
                processMethodInField(field, object, "setFileFilter", fileNameExtensionFilter,
                                FileFilter.class);
        }

        @Override
        protected void process(Class<?> clazz, Object object, AddFileFilter annotation) throws LogException {
                FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter(annotation.description(),
                                annotation.value());
                processMethodInClass(clazz, object, "setFileFilter", fileNameExtensionFilter,
                                FileFilter.class);
        }

}
