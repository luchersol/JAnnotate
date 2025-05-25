package io.github.luchersol.processors.mixed.fields_classes.menu;

import java.lang.reflect.Field;

import javax.swing.JMenuBar;

import io.github.luchersol.annotations.mixed.fields_classes.menu.SetJMenuBar;
import io.github.luchersol.common.abstractClasses.AbstractFieldAndClassProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.common.exceptions.LogException;
import io.github.luchersol.common.exceptions.SevereException;

@JProcessor
public class SetJMenuBarProcessor extends AbstractFieldAndClassProcessor<SetJMenuBar> {

    @Override
    public void process(Field field, Object object, SetJMenuBar annotation) throws LogException {
        try {
            JMenuBar jMenuBar = getFieldAs(annotation.value(), object, JMenuBar.class);
            processMethodInField(field, object, "setJMenuBar", jMenuBar, JMenuBar.class);
        } catch (Exception e) {
            SevereException.throwException(e);
        }
    }

    @Override
    public void process(Class<?> clazz, Object object, SetJMenuBar annotation) throws LogException {
        try {
            JMenuBar jMenuBar = getFieldAs(annotation.value(), object, JMenuBar.class);
            processMethodInClass(clazz, object, "setJMenuBar", jMenuBar, JMenuBar.class);
        } catch (Exception e) {
            SevereException.throwException(e);
        }
    }

}
