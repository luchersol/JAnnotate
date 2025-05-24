package io.github.luchersol.processors.fields;

import java.lang.reflect.Field;

import javax.swing.KeyStroke;

import io.github.luchersol.annotations.fields.SetAccelerator;
import io.github.luchersol.common.abstractClasses.AbstractFieldProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.common.exceptions.LogException;
import io.github.luchersol.common.exceptions.SevereException;

@JProcessor
public class SetAcceleratorProcessor extends AbstractFieldProcessor<SetAccelerator> {

    @Override
    public void process(Field field, Object object, SetAccelerator annotation) throws LogException {
        try {
            KeyStroke keyStroke = KeyStroke.getKeyStroke(annotation.value());
            keyStroke = KeyStroke.getKeyStroke(keyStroke.getKeyCode(), keyStroke.getModifiers(),
                    annotation.onKeyRelease());
            processMethodInField(field, object, "setAccelerator", keyStroke, KeyStroke.class);
        } catch (Exception e) {
            SevereException.throwException(e);
        }
    }

}
