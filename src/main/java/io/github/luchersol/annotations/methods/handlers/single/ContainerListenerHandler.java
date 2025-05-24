package io.github.luchersol.annotations.methods.handlers.single;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import io.github.luchersol.annotations.methods.handlers.group.ContainerListenerHandlers;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(ContainerListenerHandlers.class)
public @interface ContainerListenerHandler {

    String value();

    String[] args() default {};

}
