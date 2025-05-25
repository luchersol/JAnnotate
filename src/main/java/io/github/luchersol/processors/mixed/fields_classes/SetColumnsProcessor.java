package io.github.luchersol.processors.mixed.fields_classes;

import java.lang.reflect.Field;

import io.github.luchersol.annotations.mixed.fields_classes.SetColumns;
import io.github.luchersol.common.abstractClasses.AbstractFieldAndClassProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.common.exceptions.LogException;

@JProcessor
public class SetColumnsProcessor extends AbstractFieldAndClassProcessor<SetColumns> {

    @Override
    public void process(Field field, Object object, SetColumns annotation) throws LogException {
        processMethodInField(field, object, "setColumns", new Object[] { annotation.value() }, int.class);
    }

    @Override
    public void process(Class<?> clazz, Object object, SetColumns annotation) throws LogException {
        processMethodInClass(clazz, object, "setColumns", int.class);
    }

}
