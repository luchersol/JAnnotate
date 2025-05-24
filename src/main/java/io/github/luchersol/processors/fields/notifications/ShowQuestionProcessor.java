package io.github.luchersol.processors.fields.notifications;

import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.function.Function;

import io.github.luchersol.annotations.fields.notifications.ShowQuestion;
import io.github.luchersol.common.abstractClasses.AbstractFieldProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.common.enums.QuestionType;
import io.github.luchersol.common.exceptions.LogException;
import io.github.luchersol.common.exceptions.SevereException;
import io.github.luchersol.common.utils.NotificationUtils;

@JProcessor
public class ShowQuestionProcessor extends AbstractFieldProcessor<ShowQuestion> {

    @Override
    public void process(Field field, Object object, ShowQuestion annotation) throws LogException {
        try {
            String title = annotation.title(), message = annotation.message();
            String[] functions = annotation.functions();
            QuestionType questionType = annotation.questionType();
            Method[] optionFunctions = new Method[functions.length];
            String[] optionTitles = new String[functions.length];

            for (int i = 0; i < functions.length; i++) {
                String[] parts = functions[i].split(":", 2);
                optionFunctions[i] = getMethod(object.getClass(), parts[0]);
                optionTitles[i] = parts[1];
            }
            ActionListener actionListener = null;
            if (QuestionType.CUSTOM == questionType) {
                actionListener = NotificationUtils.showQuestionCustom(message, title, questionType, optionTitles,
                        optionFunctions, object);
            } else {
                Function<String, Method> function = i -> {
                    try {
                        return "".equals(i) ? null
                                : getMethod(object.getClass(), annotation.okFunction());
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                        return null;
                    }
                };
                Method okFunction = function.apply(annotation.okFunction()),
                        noFunction = function.apply(annotation.noFunction()),
                        cancelFunction = function.apply(annotation.cancelFunction()),
                        closeFunction = function.apply(annotation.closeFunction());
                actionListener = NotificationUtils.showQuestion(message, title, questionType, okFunction, noFunction,
                        cancelFunction, closeFunction, object);
            }

            processMethodInField(field, object, "addActionListener", actionListener, ActionListener.class);
        } catch (Exception e) {
            SevereException.throwException(e);
        }
    }

}
