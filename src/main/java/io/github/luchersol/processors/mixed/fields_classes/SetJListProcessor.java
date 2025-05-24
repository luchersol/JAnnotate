package com.jannotate.processors.mixed.fields_classes;

import java.lang.reflect.Field;
import java.util.Arrays;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import com.jannotate.annotations.mixed.fields_classes.SetJList;
import com.jannotate.common.abstractClasses.AbstractFieldAndClassProcessor;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.common.exceptions.LogException;
import com.jannotate.common.exceptions.SevereException;

@JProcessor
public class SetJListProcessor extends AbstractFieldAndClassProcessor<SetJList> {

    @Override
    protected void process(Field field, Object object, SetJList annotation) throws LogException {
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
    protected void process(Class<?> clazz, Object object, SetJList annotation) throws LogException {
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
