package com.jannotate.annotations.fields.listeners.group.scroll;

import com.jannotate.annotations.fields.listeners.single.scroll.AddAdjustmentListener;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AddAdjustmentListeners {
  AddAdjustmentListener[] value() default {};
}
