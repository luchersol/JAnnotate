package io.github.luchersol.annotations.mixed.fields_classes.file_chooser;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface AddFileFilters {
    AddFileFilter[] value() default {};

    String defaultFilter() default "";
}
