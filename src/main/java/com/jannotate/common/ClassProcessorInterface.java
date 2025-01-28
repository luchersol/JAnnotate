package com.jannotate.common;

public interface ClassProcessorInterface extends AbstractProcessorInterface{
    void process( Class<?> clazz, Object object);
}
