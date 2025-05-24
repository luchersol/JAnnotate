package io.github.luchersol.common.annotations;

public @interface MethodAndArgs {
    String value() default "";

    String[] args() default {};

    Class<?>[] type_args() default {};
}
