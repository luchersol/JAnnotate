package io.github.luchersol.annotations.methods.handlers.single.hierarchy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import io.github.luchersol.annotations.methods.handlers.group.hierarchy.HierarchyListenerHandlers;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(HierarchyListenerHandlers.class)
public @interface HierarchyListenerHandler {

    String value();

    String[] args() default {};

}
