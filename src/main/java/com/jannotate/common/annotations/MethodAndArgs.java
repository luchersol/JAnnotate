package com.jannotate.common.annotations;

public @interface MethodAndArgs {
    String value() default "";

    String[] args() default {};

    Class<?>[] type_args() default {};
}
