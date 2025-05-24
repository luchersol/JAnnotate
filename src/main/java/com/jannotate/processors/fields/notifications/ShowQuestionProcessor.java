package com.jannotate.processors.fields.notifications;

import java.awt.event.ActionListener;
import java.lang.reflect.Field;

import com.jannotate.annotations.fields.notifications.ShowQuestion;
import com.jannotate.common.abstractClasses.AbstractFieldProcessor;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.common.exceptions.LogException;
import com.jannotate.common.exceptions.SevereException;
import com.jannotate.common.utils.NotificationUtils;

@JProcessor
public class ShowQuestionProcessor extends AbstractFieldProcessor<ShowQuestion> {

    @Override
    public void process(Field field, Object object, ShowQuestion annotation) throws LogException {
        try {
            String title = annotation.title(), message = annotation.message();
            ActionListener actionListener = NotificationUtils.showQuestion(message, title);
            processMethodInField(field, object, "addActionListener", actionListener, ActionListener.class);
        } catch (Exception e) {
            SevereException.throwException(e);
        }
    }

}
