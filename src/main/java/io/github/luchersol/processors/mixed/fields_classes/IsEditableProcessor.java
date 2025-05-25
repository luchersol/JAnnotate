package io.github.luchersol.processors.mixed.fields_classes;

import java.lang.reflect.Field;

import io.github.luchersol.annotations.mixed.fields_classes.IsEditable;
import io.github.luchersol.common.abstractClasses.AbstractFieldAndClassProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.common.exceptions.LogException;
import io.github.luchersol.common.exceptions.SevereException;

@JProcessor
public class IsEditableProcessor extends AbstractFieldAndClassProcessor<IsEditable> {

    @Override
    public void process(Field field, Object object, IsEditable annotation) throws LogException {
        try {
            processMethodInField(field, object, "setEditable", annotation.value(), boolean.class);
        } catch (Exception e) {
            SevereException.throwException(e);
        }
    }

    @Override
    public void process(Class<?> clazz, Object object, IsEditable annotation) throws LogException {
        try {
            processMethodInClass(clazz, object, "setEditable", annotation.value(), boolean.class);
        } catch (Exception e) {
            SevereException.throwException(e);
        }
    }

}
