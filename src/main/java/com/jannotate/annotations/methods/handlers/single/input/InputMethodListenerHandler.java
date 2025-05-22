package com.jannotate.annotations.methods.handlers.single.input;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.jannotate.annotations.methods.handlers.group.input.InputMethodListenerHandlers;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(InputMethodListenerHandlers.class)
public @interface InputMethodListenerHandler {
    String value();

    String[] args() default {};
}
