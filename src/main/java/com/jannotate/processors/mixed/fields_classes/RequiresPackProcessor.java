package com.jannotate.processors.mixed.fields_classes;

import java.lang.reflect.Field;

import com.jannotate.annotations.mixed.fields_classes.RequiresPack;
import com.jannotate.common.abstractClasses.AbstractFieldAndClassProcessor;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.common.annotations.PriorityAnnotation;
import com.jannotate.common.exceptions.LogException;

@JProcessor
@PriorityAnnotation(value = -1, annotations = { IsVisibleProcessor.class })
public class RequiresPackProcessor extends AbstractFieldAndClassProcessor<RequiresPack> {

    @Override
    protected void process(Field field, Object object, RequiresPack annotation) throws LogException {
        processMethodInField(field, object, "pack");
    }

    @Override
    protected void process(Class<?> clazz, Object object, RequiresPack annotation) throws LogException {
        processMethodInClass(clazz, object, "pack");
    }

}
