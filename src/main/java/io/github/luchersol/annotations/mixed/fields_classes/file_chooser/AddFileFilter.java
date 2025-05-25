package io.github.luchersol.annotations.mixed.fields_classes.file_chooser;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.TYPE, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(AddFileFilters.class)
public @interface AddFileFilter {
    String[] value() default {};

    String description() default "Default Filter";

}
