package com.jannotate.common;

import java.lang.reflect.Field;

public interface FieldProcessor {

    void process(Field field, Object object);
    
}
