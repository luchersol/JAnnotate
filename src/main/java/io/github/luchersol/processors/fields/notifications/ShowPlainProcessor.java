package io.github.luchersol.processors.fields.notifications;

import java.awt.event.ActionListener;
import java.lang.reflect.Field;

import io.github.luchersol.annotations.fields.notifications.ShowPlain;
import io.github.luchersol.common.abstractClasses.AbstractFieldProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.common.exceptions.LogException;
import io.github.luchersol.common.exceptions.SevereException;
import io.github.luchersol.common.utils.NotificationUtils;

@JProcessor
public class ShowPlainProcessor extends AbstractFieldProcessor<ShowPlain> {

    @Override
    public void process(Field field, Object object, ShowPlain annotation) throws LogException {
        try {
            String title = annotation.title(), message = annotation.message();
            ActionListener actionListener = NotificationUtils.showPlain(message, title);
            processMethodInField(field, object, "addActionListener", actionListener, ActionListener.class);
        } catch (Exception e) {
            SevereException.throwException(e);
        }
    }

}
