package com.jannotate.annotations.fields.listeners.single;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.jannotate.common.MethodAndArgs;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ComponentKeyListener {
    MethodAndArgs keyType() default @MethodAndArgs();
    MethodAndArgs keyPressed() default @MethodAndArgs();
    MethodAndArgs keyReleased() default @MethodAndArgs();
}
