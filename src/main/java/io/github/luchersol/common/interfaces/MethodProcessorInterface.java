package io.github.luchersol.common.interfaces;

import java.lang.reflect.Method;

public interface MethodProcessorInterface extends AbstractProcessorInterface {

    void process(Method method, Object object);

}
