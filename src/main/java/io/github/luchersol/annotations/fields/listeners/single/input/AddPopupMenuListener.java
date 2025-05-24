package com.jannotate.annotations.fields.listeners.single.input;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.jannotate.common.annotations.MethodAndArgs;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AddPopupMenuListener {
    MethodAndArgs onMenuSelected() default @MethodAndArgs();

    MethodAndArgs onMenuDeselected() default @MethodAndArgs();

    MethodAndArgs onMenuCanceled() default @MethodAndArgs();
}
