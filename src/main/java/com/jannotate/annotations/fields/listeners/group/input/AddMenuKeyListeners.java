package com.jannotate.annotations.fields.listeners.group.input;

import com.jannotate.annotations.fields.listeners.single.input.AddMenuKeyListener;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AddMenuKeyListeners {
  AddMenuKeyListener[] value() default {};
}
