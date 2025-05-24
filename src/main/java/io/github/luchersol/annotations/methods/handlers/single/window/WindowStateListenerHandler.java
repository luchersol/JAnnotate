package com.jannotate.annotations.methods.handlers.single.window;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.jannotate.annotations.methods.handlers.group.window.WindowStateListenerHandlers;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(WindowStateListenerHandlers.class)
public @interface WindowStateListenerHandler {
    String method() default "";

    String[] args() default {};

    Class<?>[] type_args() default {};
}
