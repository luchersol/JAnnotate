package io.github.luchersol.processors.fields.notifications;

import java.awt.event.ActionListener;
import java.lang.reflect.Field;

import io.github.luchersol.annotations.fields.notifications.ShowWarning;
import io.github.luchersol.common.abstractClasses.AbstractFieldProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.common.exceptions.LogException;
import io.github.luchersol.common.exceptions.SevereException;
import io.github.luchersol.common.utils.NotificationUtils;

@JProcessor
public class ShowWarningProcessor extends AbstractFieldProcessor<ShowWarning> {

    @Override
    public void process(Field field, Object object, ShowWarning annotation) throws LogException {
        try {
            String title = annotation.title(), message = annotation.message();
            ActionListener actionListener = NotificationUtils.showWarning(message, title);
            processMethodInField(field, object, "addActionListener", actionListener, ActionListener.class);
        } catch (Exception e) {
            SevereException.throwException(e);
        }
    }

}
