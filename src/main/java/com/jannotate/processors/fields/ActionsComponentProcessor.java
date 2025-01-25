package com.jannotate.processors.fields;

import java.lang.reflect.Field;

import com.jannotate.annotations.fields.ActionComponent;
import com.jannotate.annotations.fields.ActionsComponent;
import com.jannotate.common.FieldProcessor;

public class ActionsComponentProcessor implements FieldProcessor {
 
    public void process(Field field, Object object) {
        if (field.isAnnotationPresent(ActionsComponent.class)) {
            ActionsComponent actionAnnotation = field.getAnnotation(ActionsComponent.class);
            field.setAccessible(true);
            for (ActionComponent actionComponent : actionAnnotation.actions()) {
                ActionComponentProcessor.processActionComponent(field, object, actionComponent);
            }
        }
        
    }
}
