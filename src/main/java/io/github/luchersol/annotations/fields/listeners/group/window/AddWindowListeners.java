package io.github.luchersol.annotations.fields.listeners.group.window;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import io.github.luchersol.annotations.fields.listeners.single.window.AddWindowListener;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AddWindowListeners {
  AddWindowListener[] value() default {};
}
