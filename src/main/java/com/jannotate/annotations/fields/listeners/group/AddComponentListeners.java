package com.jannotate.annotations.fields.listeners.group;

import com.jannotate.annotations.fields.listeners.single.AddComponentListener;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AddComponentListeners {
  AddComponentListener[] value() default {};
}
