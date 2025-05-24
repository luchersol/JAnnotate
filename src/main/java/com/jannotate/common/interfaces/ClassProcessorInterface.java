package com.jannotate.common.interfaces;

public interface ClassProcessorInterface extends AbstractProcessorInterface {
    void process(Class<?> clazz, Object object);

}
