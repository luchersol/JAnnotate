package io.github.luchersol.processors.mixed.fields_classes;

import java.lang.reflect.Field;

import io.github.luchersol.annotations.mixed.fields_classes.SetDefaultClose;
import io.github.luchersol.common.abstractClasses.AbstractFieldAndClassProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.common.exceptions.LogException;

@JProcessor
public class SetDefaultCloseProcessor extends AbstractFieldAndClassProcessor<SetDefaultClose> {

    @Override
    public void process(Field field, Object object, SetDefaultClose annotation) throws LogException {
        processMethodInField(field, object, "setDefaultCloseOperation", annotation.value(), int.class);
    }

    @Override
    public void process(Class<?> clazz, Object object, SetDefaultClose annotation) throws LogException {
        processMethodInClass(clazz, object, "setDefaultCloseOperation", annotation.value(), int.class);
    }

}
