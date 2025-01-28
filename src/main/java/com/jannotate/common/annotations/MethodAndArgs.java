package com.jannotate.common.annotations;

public @interface MethodAndArgs {
    String method() default "";
    String[] args() default {};
}
