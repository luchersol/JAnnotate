package com.jannotate.annotations.methods.handlers.single.input;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MenuKeyListenerHandler {
    String component();

    String[] args() default {};

}
