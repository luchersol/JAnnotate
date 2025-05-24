package com.jannotate.annotations.fields.notifications;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.jannotate.common.enums.QuestionType;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ShowQuestion {

    String title();

    String message();

    QuestionType questionType() default QuestionType.CUSTOM;

    String[] functions() default {};

    String okFunction() default "";

    String noFunction() default "";

    String cancelFunction() default "";

    String closeFunction() default "";

}
