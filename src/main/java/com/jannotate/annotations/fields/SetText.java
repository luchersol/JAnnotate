package com.jannotate.annotations.fields;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.jannotate.common.TextColor;


@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SetText {
    String text() default "";
    TextColor color() default TextColor.NULL;
    int red() default 0;
    int green() default 0;
    int blue() default 0;
}
