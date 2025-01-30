package com.jannotate.processors.classes.layoutManager;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.jannotate.annotations.classes.AutoAddComponents;
import com.jannotate.annotations.classes.layoutManager.DesactivateLayout;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.common.annotations.PriorityAnnotation;
import com.jannotate.common.interfaces.ClassProcessorInterface;

@JProcessor
@PriorityAnnotation(value = 1, annotations = { AutoAddComponents.class })
public class DesactivateLayoutProcessor implements ClassProcessorInterface {

    @Override
    public void process(Class<?> clazz, Object object) {
        if (clazz.isAnnotationPresent(DesactivateLayout.class)) {
            if (object instanceof JPanel) {
                JPanel panel = (JPanel) object;
                panel.setLayout(null);
            } else if (object instanceof JFrame) {
                JFrame frame = (JFrame) object;
                frame.setLayout(null);
            }
        }
    }

}
