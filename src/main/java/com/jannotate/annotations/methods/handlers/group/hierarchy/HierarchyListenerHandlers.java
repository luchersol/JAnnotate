package com.jannotate.annotations.methods.handlers.group.hierarchy;

import com.jannotate.annotations.methods.handlers.single.hierarchy.HierarchyListenerHandler;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface HierarchyListenerHandlers {
  HierarchyListenerHandler[] value() default {};
}
