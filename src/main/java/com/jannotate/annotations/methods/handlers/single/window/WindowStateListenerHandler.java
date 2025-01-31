package com.jannotate.annotations.methods.handlers.single.window;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface WindowStateListenerHandler {
    String method() default "";

    String[] args() default {};

    Class<?>[] type_args() default {};
}
