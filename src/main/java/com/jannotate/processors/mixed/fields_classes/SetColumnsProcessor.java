package com.jannotate.processors.mixed.fields_classes;

import java.lang.reflect.Field;

import com.jannotate.annotations.mixed.fields_classes.SetColumns;
import com.jannotate.common.abstractClasses.AbstractFieldAndClassProcessor;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.common.exceptions.LogException;

@JProcessor
public class SetColumnsProcessor extends AbstractFieldAndClassProcessor<SetColumns> {

    @Override
    protected void process(Field field, Object object, SetColumns annotation) throws LogException {
        processMethodInField(field, object, "setColumns", new Object[] { annotation.value() }, int.class);
    }

    @Override
    protected void process(Class<?> clazz, Object object, SetColumns annotation) throws LogException {
        processMethodInClass(clazz, object, "setColumns", int.class);
    }

}
