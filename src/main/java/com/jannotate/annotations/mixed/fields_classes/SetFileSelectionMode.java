package com.jannotate.annotations.mixed.fields_classes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.swing.JFileChooser;

@Target({ ElementType.FIELD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface SetFileSelectionMode {
    /**
     * <p>
     * Options:
     * <ul>
     * <li>JFileChooser.FILES_ONLY
     * <li>JFileChooser.DIRECTORIES_ONLY
     * <li>JFileChooser.FILES_AND_DIRECTORIES
     * </ul>
     * <br>
     */
    int value() default JFileChooser.FILES_ONLY;
}
