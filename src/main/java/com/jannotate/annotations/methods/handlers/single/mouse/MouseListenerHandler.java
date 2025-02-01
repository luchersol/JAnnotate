package com.jannotate.annotations.methods.handlers.single.mouse;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MouseListenerHandler {
    String value() default "";

    String[] args() default {};

}
