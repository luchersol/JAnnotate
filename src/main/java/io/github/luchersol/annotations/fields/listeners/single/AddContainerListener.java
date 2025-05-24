package io.github.luchersol.annotations.fields.listeners.single;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import io.github.luchersol.common.annotations.MethodAndArgs;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AddContainerListener {

    MethodAndArgs onContainerAdded() default @MethodAndArgs();

    MethodAndArgs onContainerRemoved() default @MethodAndArgs();

}
