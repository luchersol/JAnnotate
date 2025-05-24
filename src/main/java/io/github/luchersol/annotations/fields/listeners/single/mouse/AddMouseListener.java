package io.github.luchersol.annotations.fields.listeners.single.mouse;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import io.github.luchersol.common.annotations.MethodAndArgs;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AddMouseListener {
    MethodAndArgs onMouseClicked() default @MethodAndArgs();

    MethodAndArgs onMousePressed() default @MethodAndArgs();

    MethodAndArgs onMouseReleased() default @MethodAndArgs();

    MethodAndArgs onMouseEntered() default @MethodAndArgs();

    MethodAndArgs onMouseExited() default @MethodAndArgs();

}
