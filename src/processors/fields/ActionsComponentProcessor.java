package src.processors.fields;

import java.lang.reflect.Field;

import src.annotations.fields.ActionComponent;
import src.annotations.fields.ActionsComponent;

public class ActionsComponentProcessor {
 
    public static void process(Field field, Object object) {
        if (field.isAnnotationPresent(ActionsComponent.class)) {
            ActionsComponent actionAnnotation = field.getAnnotation(ActionsComponent.class);
            field.setAccessible(true);
            for (ActionComponent actionComponent : actionAnnotation.actions()) {
                ActionComponentProcessor.processActionComponent(field, object, actionComponent);
            }
        }
        
    }
}
