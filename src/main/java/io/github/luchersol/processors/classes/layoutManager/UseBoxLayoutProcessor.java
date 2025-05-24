package io.github.luchersol.processors.classes.layoutManager;

import java.awt.Container;
import java.awt.LayoutManager;
import java.lang.reflect.Constructor;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import io.github.luchersol.annotations.classes.AutoAddComponents;
import io.github.luchersol.annotations.classes.layoutManager.UseBoxLayout;
import io.github.luchersol.common.abstractClasses.AbstractClassProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.common.annotations.PriorityAnnotation;
import io.github.luchersol.common.exceptions.LogException;

@JProcessor
@PriorityAnnotation(value = 1, annotations = { AutoAddComponents.class })
public class UseBoxLayoutProcessor extends AbstractClassProcessor<UseBoxLayout> {

    @Override
    public void process(Class<?> clazz, Object object, UseBoxLayout annotation) throws LogException {
        if (object instanceof JPanel) {
            JPanel panel = (JPanel) object;
            applyLayout(panel, BoxLayout.class, annotation);
        } else if (object instanceof JFrame) {
            JFrame frame = (JFrame) object;
            applyLayout(frame.getContentPane(), BoxLayout.class, annotation);
        }
    }

    private static void applyLayout(Container container, Class<? extends LayoutManager> layoutClass,
            UseBoxLayout annotation) {
        try {
            int axis = annotation.axis();
            // Crear una instancia del LayoutManager
            Constructor<? extends LayoutManager> constructor = layoutClass.getDeclaredConstructor(Container.class,
                    int.class);
            LayoutManager layoutManager = constructor.newInstance(container, axis);
            container.setLayout(layoutManager); // Asignar el layout al contenedor
        } catch (Exception e) {
            e.printStackTrace();
            // En caso de error, podrías optar por un layout por defecto como FlowLayout.
            container.setLayout(new java.awt.FlowLayout());
        }
    }

}
