package io.github.luchersol.processors.mixed.fields_classes;

import java.lang.reflect.Field;

import io.github.luchersol.annotations.mixed.fields_classes.SetTitle;
import io.github.luchersol.common.abstractClasses.AbstractFieldAndClassProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.common.exceptions.LogException;

@JProcessor
public class SetTitleProcessor extends AbstractFieldAndClassProcessor<SetTitle> {

    @Override
    public void process(Field field, Object object, SetTitle annotation) throws LogException {
        processMethodInField(field, object, "setTitle", annotation.value(), String.class);
    }

    @Override
    public void process(Class<?> clazz, Object object, SetTitle annotation) throws LogException {
        processMethodInClass(clazz, object, "setTitle", annotation.value(), String.class);
    }

}
