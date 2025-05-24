package com.jannotate.annotations.fields.listeners.group;

import com.jannotate.annotations.fields.listeners.single.AddKeyListener;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AddKeyListeners {
  AddKeyListener[] value() default {};
}
