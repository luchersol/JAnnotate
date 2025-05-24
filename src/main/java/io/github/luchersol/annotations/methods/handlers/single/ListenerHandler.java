package io.github.luchersol.annotations.methods.handlers.single;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.EventListener;

import io.github.luchersol.annotations.methods.handlers.group.ListenerHandlers;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(ListenerHandlers.class)
public @interface ListenerHandler {

    String value();

    String[] args() default {};

    Class<? extends EventListener> type();

    String addMethod() default "";

}
