package com.jannotate.annotations.methods.handlers.single.mouse;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MouseListenerHandler {
    String component();

    String[] args() default {};

}
