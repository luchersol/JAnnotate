package com.jannotate.annotations.methods.handlers.single;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.EventListener;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ListenerHandler {

    String value();

    String[] args() default {};

    Class<? extends EventListener> type();

    String addMethod() default "";

}
