package com.jannotate.common.interfaces;

import java.lang.reflect.Field;

public interface FieldProcessorInterface extends AbstractProcessorInterface {

    void process(Field field, Object object);
    
}
