package io.github.luchersol.processors.fields.notifications;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

import javax.swing.JOptionPane;

import io.github.luchersol.annotations.fields.notifications.ShowMessage;
import io.github.luchersol.common.abstractClasses.AbstractFieldProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.common.enums.NotificationType;
import io.github.luchersol.common.exceptions.LogException;
import io.github.luchersol.common.exceptions.SevereException;

@JProcessor
public class ShowMessageProcessor extends AbstractFieldProcessor<ShowMessage> {

    @Override
    public void process(Field field, Object object, ShowMessage annotation) throws LogException {
        try {
            String title = annotation.title(), message = annotation.message();
            NotificationType notificationType = annotation.type();
            ActionListener actionListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, message, title, notificationType.getValue());
                }
            };
            processMethodInField(field, object, "addActionListener", actionListener, ActionListener.class);
        } catch (Exception e) {
            SevereException.throwException(e);
        }
    }

}
