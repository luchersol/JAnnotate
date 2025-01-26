package com.jannotate.processors.fields;

import java.lang.reflect.Field;

import com.jannotate.annotations.fields.ActionMethod;
import com.jannotate.annotations.fields.ActionMethods;
import com.jannotate.common.FieldProcessor;

public class ActionMethodsProcessor implements FieldProcessor {
 
    public void process(Field field, Object object) {
        if (field.isAnnotationPresent(ActionMethods.class)) {
            ActionMethods actionAnnotation = field.getAnnotation(ActionMethods.class);
            field.setAccessible(true);
            for (ActionMethod actionComponent : actionAnnotation.actions()) {
                ActionMethodProcessor.processActionComponent(field, object, actionComponent);
            }
        }
        
    }
}
