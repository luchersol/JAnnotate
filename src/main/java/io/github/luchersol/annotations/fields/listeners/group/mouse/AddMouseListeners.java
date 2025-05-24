package com.jannotate.annotations.fields.listeners.group.mouse;

import com.jannotate.annotations.fields.listeners.single.mouse.AddMouseListener;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AddMouseListeners {
  AddMouseListener[] value() default {};
}
