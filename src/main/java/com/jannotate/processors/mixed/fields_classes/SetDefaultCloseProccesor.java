package com.jannotate.processors.mixed.fields_classes;

import java.lang.reflect.Field;

import com.jannotate.annotations.mixed.fields_classes.SetDefaultClose;
import com.jannotate.common.abstractClasses.AbstractFieldAndClassProcessor;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.common.exceptions.LogException;

@JProcessor
public class SetDefaultCloseProccesor extends AbstractFieldAndClassProcessor<SetDefaultClose> {

    @Override
    protected void process(Field field, Object object, SetDefaultClose annotation) throws LogException {
        processMethodInField(field, object, "setDefaultCloseOperation", annotation.value(), int.class);
    }

    @Override
    protected void process(Class<?> clazz, Object object, SetDefaultClose annotation) throws LogException {
        processMethodInClass(clazz, object, "setDefaultCloseOperation", annotation.value(), int.class);
    }

}
