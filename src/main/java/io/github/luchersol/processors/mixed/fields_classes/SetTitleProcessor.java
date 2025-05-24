package com.jannotate.processors.mixed.fields_classes;

import java.lang.reflect.Field;

import com.jannotate.annotations.mixed.fields_classes.SetTitle;
import com.jannotate.common.abstractClasses.AbstractFieldAndClassProcessor;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.common.exceptions.LogException;

@JProcessor
public class SetTitleProcessor extends AbstractFieldAndClassProcessor<SetTitle> {

    @Override
    protected void process(Field field, Object object, SetTitle annotation) throws LogException {
        processMethodInField(field, object, "setTitle", annotation.value(), String.class);
    }

    @Override
    protected void process(Class<?> clazz, Object object, SetTitle annotation) throws LogException {
        processMethodInClass(clazz, object, "setTitle", annotation.value(), String.class);
    }

}
