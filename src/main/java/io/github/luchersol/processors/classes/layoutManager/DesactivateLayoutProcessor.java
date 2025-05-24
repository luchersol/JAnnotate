package com.jannotate.processors.classes.layoutManager;

import java.awt.LayoutManager;

import com.jannotate.annotations.classes.AutoAddComponents;
import com.jannotate.annotations.classes.layoutManager.DesactivateLayout;
import com.jannotate.common.abstractClasses.AbstractClassProcessor;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.common.annotations.PriorityAnnotation;
import com.jannotate.common.exceptions.LogException;
import com.jannotate.common.exceptions.SevereException;

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
