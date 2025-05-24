package io.github.luchersol.annotations.fields.listeners.group.mouse;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import io.github.luchersol.annotations.fields.listeners.single.mouse.AddMouseMotionListener;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AddMouseMotionListeners {
  AddMouseMotionListener[] value() default {};
}
