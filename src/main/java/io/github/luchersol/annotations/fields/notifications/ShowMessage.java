package io.github.luchersol.annotations.fields.notifications;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import io.github.luchersol.common.enums.NotificationType;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ShowMessage {

    String title();

    String message();

    NotificationType type() default NotificationType.INFORMATION;

}
