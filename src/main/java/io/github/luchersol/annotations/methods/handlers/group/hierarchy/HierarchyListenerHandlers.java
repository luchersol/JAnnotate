package io.github.luchersol.annotations.methods.handlers.group.hierarchy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import io.github.luchersol.annotations.methods.handlers.single.hierarchy.HierarchyListenerHandler;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface HierarchyListenerHandlers {
  HierarchyListenerHandler[] value() default {};
}
