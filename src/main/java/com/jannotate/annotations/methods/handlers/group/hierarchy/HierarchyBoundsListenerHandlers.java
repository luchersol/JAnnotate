package com.jannotate.annotations.methods.handlers.group.hierarchy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.jannotate.annotations.methods.handlers.single.hierarchy.HierarchyBoundsListenerHandler;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface HierarchyBoundsListenerHandlers {
    HierarchyBoundsListenerHandler[] value() default {};
}
