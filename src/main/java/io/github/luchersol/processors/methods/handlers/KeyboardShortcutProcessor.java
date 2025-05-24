package io.github.luchersol.processors.methods.handlers;

import java.awt.event.ActionEvent;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

import io.github.luchersol.annotations.methods.handlers.KeyboardShortcut;
import io.github.luchersol.common.abstractClasses.AbstractMethodProccessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.common.exceptions.LogException;
import io.github.luchersol.common.exceptions.SevereException;
import io.github.luchersol.common.exceptions.WarningException;

@JProcessor
public class KeyboardShortcutProcessor extends AbstractMethodProccessor<KeyboardShortcut> {

    @Override
    public void process(Method method, Object object, KeyboardShortcut annotation) throws LogException {
        try {
            KeyStroke keyStroke = KeyStroke.getKeyStroke(annotation.value());
            if (keyStroke == null)
                throw new Exception(String.format("%s no es un argumento valido para atajos", annotation.value()));
            keyStroke = KeyStroke.getKeyStroke(keyStroke.getKeyCode(), keyStroke.getModifiers(),
                    annotation.onKeyRelease());
            AbstractAction abstractAction = annotation.introduce_abstract_action()
                    ? invokeMethod(method, object, annotation.args(), AbstractAction.class)
                    : new AbstractAction() {

                        @Override
                        public void actionPerformed(ActionEvent event) {
                            try {
                                invokeMethod(method, object, annotation.args());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                    };

            putKeyStroke(object, keyStroke, annotation.value(), abstractAction, annotation.condition());

        } catch (WarningException e) {
            WarningException.throwException(e);
        } catch (Exception e) {
            SevereException.throwException(e);
        }
    }

    public void putKeyStroke(Object object, KeyStroke keyStroke, String actionKey, AbstractAction abstractAction,
            int condition) throws Exception {
        JComponent jComponent;
        if (object instanceof JFrame) {
            jComponent = ((JFrame) object).getRootPane();
        } else if (object instanceof JComponent) {
            jComponent = (JComponent) object;
        } else {
            throw new Exception("Object isn't valid");
        }
        List<String> errorMessages = new ArrayList<>();
        InputMap inputMap = jComponent.getInputMap(condition);
        ActionMap actionMap = jComponent.getActionMap();
        if (inputMap.get(keyStroke) != null)
            errorMessages.add("Key Stroke repait");
        if (actionMap.get(actionKey) != null)
            errorMessages.add("Action key repait");

        inputMap.put(keyStroke, actionKey);
        actionMap.put(actionKey, abstractAction);
        if (!errorMessages.isEmpty()) {
            WarningException.throwException(errorMessages);
        }

    }

}
