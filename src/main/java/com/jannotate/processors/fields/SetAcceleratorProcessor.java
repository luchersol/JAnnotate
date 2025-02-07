package com.jannotate.processors.fields;

import java.lang.reflect.Field;

import javax.swing.KeyStroke;

import com.jannotate.annotations.fields.SetAccelerator;
import com.jannotate.common.abstractClasses.AbstractFieldProcessor;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.common.exceptions.SevereException;

@JProcessor
public class SetAcceleratorProcessor extends AbstractFieldProcessor<SetAccelerator> {

    @Override
    public void process(Field field, Object object, SetAccelerator annotation) throws SevereException {
        try {
            KeyStroke keyStroke = KeyStroke.getKeyStroke(annotation.value());
            keyStroke = KeyStroke.getKeyStroke(keyStroke.getKeyCode(), keyStroke.getModifiers(),
                    annotation.onKeyRelease());
            processMethodInField(field, object, "setAccelerator", keyStroke, KeyStroke.class);
        } catch (Exception e) {
            SevereException.throw_exception(e);
        }
    }

}
