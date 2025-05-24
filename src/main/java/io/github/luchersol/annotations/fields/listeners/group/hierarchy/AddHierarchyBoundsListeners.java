package io.github.luchersol.annotations.fields.listeners.group.hierarchy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import io.github.luchersol.annotations.fields.listeners.single.hierarchy.AddHierarchyBoundsListener;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AddHierarchyBoundsListeners {
  AddHierarchyBoundsListener[] value() default {};
}
