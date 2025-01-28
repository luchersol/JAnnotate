package com.jannotate.common.annotations;

public @interface InsetsAnnotation {
    int top() default 0;
    int left() default 0;
    int bottom() default 0;
    int right() default 0;
}
