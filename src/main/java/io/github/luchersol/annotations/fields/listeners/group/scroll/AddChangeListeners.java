package io.github.luchersol.annotations.fields.listeners.group.scroll;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import io.github.luchersol.annotations.fields.listeners.single.scroll.AddChangeListener;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AddChangeListeners {
  AddChangeListener[] value() default {};
}
