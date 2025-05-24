package com.jannotate.annotations.fields.listeners.group.window;

import com.jannotate.annotations.fields.listeners.single.window.AddWindowListener;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AddWindowListeners {
  AddWindowListener[] value() default {};
}
