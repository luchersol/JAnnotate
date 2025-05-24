package io.github.luchersol.processors.fields.listeners.single;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.swing.AbstractButton;

import io.github.luchersol.annotations.fields.listeners.single.AddActionListener;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.common.abstractClasses.AbstractListenerProcessor;

@JProcessor
public class AddActionListenerProcessor extends AbstractListenerProcessor<AddActionListener> {

    @Override
    public void process(Field field, Object object, AddActionListener annotation) {
        try {
            AbstractButton component = getFieldAs(field, object, AbstractButton.class);
            Method method = getMethod(object.getClass(), annotation.value(), annotation.type_args());
            Object[] args = parseArguments(method, annotation.args());
            component.addActionListener(e -> {
                try {
                    method.invoke(object, args);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });

        } catch (Exception e) {
            logger.severe(e.getMessage());
        }
    }

}
