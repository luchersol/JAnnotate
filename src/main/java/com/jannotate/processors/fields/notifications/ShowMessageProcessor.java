package com.jannotate.processors.fields.notifications;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

import javax.swing.JOptionPane;

import com.jannotate.annotations.fields.notifications.ShowMessage;
import com.jannotate.common.abstractClasses.AbstractFieldProcessor;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.common.enums.NotificationType;
import com.jannotate.common.exceptions.LogException;
import com.jannotate.common.exceptions.SevereException;

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
