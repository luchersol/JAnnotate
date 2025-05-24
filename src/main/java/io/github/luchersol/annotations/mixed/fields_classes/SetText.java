package io.github.luchersol.annotations.mixed.fields_classes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import io.github.luchersol.common.enums.TextColor;

@Target({ ElementType.TYPE, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface SetText {
    String value() default "";

    TextColor color() default TextColor.NULL;

    int red() default 0;

    int green() default 0;

    int blue() default 0;
}
