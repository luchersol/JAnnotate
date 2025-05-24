package io.github.luchersol.processors.classes.layoutManager;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.lang.reflect.Constructor;

import javax.swing.JFrame;
import javax.swing.JPanel;

import io.github.luchersol.annotations.classes.AutoAddComponents;
import io.github.luchersol.annotations.classes.layoutManager.UseBorderLayout;
import io.github.luchersol.common.abstractClasses.AbstractClassProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.common.annotations.PriorityAnnotation;
import io.github.luchersol.common.exceptions.LogException;

@JProcessor
@PriorityAnnotation(value = 1, annotations = { AutoAddComponents.class })
public class UseBorderLayoutProcessor extends AbstractClassProcessor<UseBorderLayout> {

    @Override
    public void process(Class<?> clazz, Object object, UseBorderLayout annotation) throws LogException {
        if (object instanceof JPanel) {
            JPanel panel = (JPanel) object;
            applyLayout(panel, BorderLayout.class, annotation);
        } else if (object instanceof JFrame) {
            JFrame frame = (JFrame) object;
            applyLayout(frame.getContentPane(), BorderLayout.class, annotation);
        }
    }

    private static void applyLayout(Container container, Class<? extends LayoutManager> layoutClass,
            UseBorderLayout annotation) {
        try {
            int hgap = annotation.hgap(), vgap = annotation.vgap();
            // Crear una instancia del LayoutManager
            Constructor<? extends LayoutManager> constructor = layoutClass.getDeclaredConstructor(int.class, int.class);
            LayoutManager layoutManager = constructor.newInstance(hgap, vgap);
            container.setLayout(layoutManager); // Asignar el layout al contenedor
        } catch (Exception e) {
            e.printStackTrace();
            // En caso de error, podrías optar por un layout por defecto como FlowLayout.
            container.setLayout(new FlowLayout());
        }
    }

}
