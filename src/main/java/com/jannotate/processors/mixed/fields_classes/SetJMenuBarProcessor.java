package com.jannotate.processors.mixed.fields_classes;

import java.lang.reflect.Field;

import javax.swing.JMenuBar;

import com.jannotate.annotations.mixed.fields_classes.SetJMenuBar;
import com.jannotate.common.abstractClasses.AbstractFieldAndClassProcessor;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.common.exceptions.LogException;
import com.jannotate.common.exceptions.SevereException;

@JProcessor
public class SetJMenuBarProcessor extends AbstractFieldAndClassProcessor<SetJMenuBar> {

    @Override
    protected void process(Field field, Object object, SetJMenuBar annotation) throws LogException {
        try {
            JMenuBar jMenuBar = getFieldAs(annotation.value(), object, JMenuBar.class);
            processMethodInField(field, object, "setJMenuBar", jMenuBar, JMenuBar.class);
        } catch (Exception e) {
            SevereException.throw_exception(e);
        }
    }

    @Override
    protected void process(Class<?> clazz, Object object, SetJMenuBar annotation) throws LogException {
        try {
            JMenuBar jMenuBar = getFieldAs(annotation.value(), object, JMenuBar.class);
            processMethodInClass(clazz, object, "setJMenuBar", jMenuBar, JMenuBar.class);
        } catch (Exception e) {
            SevereException.throw_exception(e);
        }
    }

}
