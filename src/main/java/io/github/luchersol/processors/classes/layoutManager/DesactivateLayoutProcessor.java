package io.github.luchersol.processors.classes.layoutManager;

import java.awt.LayoutManager;

import io.github.luchersol.annotations.classes.AutoAddComponents;
import io.github.luchersol.annotations.classes.layoutManager.DesactivateLayout;
import io.github.luchersol.common.abstractClasses.AbstractClassProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.common.annotations.PriorityAnnotation;
import io.github.luchersol.common.exceptions.LogException;
import io.github.luchersol.common.exceptions.SevereException;

@JProcessor
@PriorityAnnotation(value = 1, annotations = { AutoAddComponents.class })
public class DesactivateLayoutProcessor extends AbstractClassProcessor<DesactivateLayout> {

    @Override
    public void process(Class<?> clazz, Object object, DesactivateLayout annotation) throws LogException {
        try {
            processMethodInClass(clazz, object, "setLayout", new Object[] { null }, LayoutManager.class);
        } catch (Exception e) {
            SevereException.throwException(e);
        }
    }

}
