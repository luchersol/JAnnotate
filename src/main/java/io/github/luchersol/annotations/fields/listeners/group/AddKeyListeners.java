package io.github.luchersol.annotations.fields.listeners.group;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import io.github.luchersol.annotations.fields.listeners.single.AddKeyListener;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AddKeyListeners {
  AddKeyListener[] value() default {};
}
