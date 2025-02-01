package com.jannotate.annotations.methods.handlers.single.hierarchy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface HierarchyBoundsListenerHandler {
    String value();

    String[] args() default {};
}
