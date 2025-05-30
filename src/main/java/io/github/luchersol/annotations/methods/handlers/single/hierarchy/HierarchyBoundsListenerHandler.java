package io.github.luchersol.annotations.methods.handlers.single.hierarchy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import io.github.luchersol.annotations.methods.handlers.group.hierarchy.HierarchyBoundsListenerHandlers;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(HierarchyBoundsListenerHandlers.class)
public @interface HierarchyBoundsListenerHandler {
    String value();

    String[] args() default {};
}
