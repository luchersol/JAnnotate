package com.jannotate.processors.classes.layoutManager;

import java.awt.Container;
import java.awt.LayoutManager;
import java.lang.reflect.Constructor;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.jannotate.annotations.classes.AutoAddComponents;
import com.jannotate.annotations.classes.layoutManager.UseLayoutManager;
import com.jannotate.common.abstractClasses.AbstractClassProcessor;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.common.annotations.PriorityAnnotation;
import com.jannotate.common.exceptions.SevereException;

@JProcessor
@PriorityAnnotation(value = 1, annotations = { AutoAddComponents.class })
public class UseLayoutManagerProcessor extends AbstractClassProcessor<UseLayoutManager> {

    @Override
    public void process(Class<?> clazz, Object object, UseLayoutManager annotation) throws SevereException {
        Class<? extends LayoutManager> layoutClass = annotation.value();

        if (object instanceof JPanel) {
            JPanel panel = (JPanel) object;
            applyLayout(panel, layoutClass);
        } else if (object instanceof JFrame) {
            JFrame frame = (JFrame) object;
            applyLayout(frame.getContentPane(), layoutClass);
        }
    }

    private static void applyLayout(Container container, Class<? extends LayoutManager> layoutClass) {
        try {
            // Crear una instancia del LayoutManager
            Constructor<? extends LayoutManager> constructor = layoutClass.getDeclaredConstructor();
            LayoutManager layoutManager = constructor.newInstance();
            container.setLayout(layoutManager); // Asignar el layout al contenedor
        } catch (Exception e) {
            e.printStackTrace();
            // En caso de error, podrías optar por un layout por defecto como FlowLayout.
            container.setLayout(new java.awt.FlowLayout());
        }
    }

}
