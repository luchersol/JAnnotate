package io.github.luchersol.annotations.fields.listeners.group.input;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import io.github.luchersol.annotations.fields.listeners.single.input.AddMenuKeyListener;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AddMenuKeyListeners {
  AddMenuKeyListener[] value() default {};
}
