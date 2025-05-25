package io.github.luchersol.processors.mixed.fields_classes;

import java.lang.reflect.Field;
import java.util.Arrays;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import io.github.luchersol.annotations.mixed.fields_classes.SetJList;
import io.github.luchersol.common.abstractClasses.AbstractFieldAndClassProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.common.exceptions.LogException;
import io.github.luchersol.common.exceptions.SevereException;

@JProcessor
public class SetJListProcessor extends AbstractFieldAndClassProcessor<SetJList> {

    @Override
    public void process(Field field, Object object, SetJList annotation) throws LogException {
        try {
            @SuppressWarnings("unchecked")
            JList<Object> jList = getFieldAs(field, object, JList.class);

            DefaultListModel<Object> modelo = new DefaultListModel<>();
            Arrays.stream(annotation.value()).map(i -> annotation.type().cast(i)).forEach(modelo::addElement);

            jList.setModel(modelo);
        } catch (Exception e) {
            SevereException.throwException(e);
        }
    }

    @Override
    public void process(Class<?> clazz, Object object, SetJList annotation) throws LogException {
        try {
            @SuppressWarnings("unchecked")
            JList<Object> jList = (JList<Object>) object;

            DefaultListModel<Object> modelo = new DefaultListModel<>();
            Arrays.stream(annotation.value()).map(i -> annotation.type().cast(i)).forEach(modelo::addElement);

            jList.setModel(modelo);
        } catch (Exception e) {
            SevereException.throwException(e);
        }
    }

}
