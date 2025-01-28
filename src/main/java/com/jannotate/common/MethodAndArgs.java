package com.jannotate.common;

public @interface MethodAndArgs {
    String method() default "";
    String[] args() default {};
}
