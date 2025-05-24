package io.github.luchersol.processors.mixed.fields_classes;

import java.lang.reflect.Field;

import io.github.luchersol.annotations.mixed.fields_classes.RequiresPack;
import io.github.luchersol.common.abstractClasses.AbstractFieldAndClassProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.common.annotations.PriorityAnnotation;
import io.github.luchersol.common.exceptions.LogException;

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
