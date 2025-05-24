package io.github.luchersol.processors.classes.layoutManager;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.lang.reflect.Constructor;

import javax.swing.JFrame;
import javax.swing.JPanel;

import io.github.luchersol.annotations.classes.AutoAddComponents;
import io.github.luchersol.annotations.classes.layoutManager.UseFlowLayout;
import io.github.luchersol.common.abstractClasses.AbstractClassProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.common.annotations.PriorityAnnotation;
import io.github.luchersol.common.exceptions.LogException;

@JProcessor
@PriorityAnnotation(value = 1, annotations = { AutoAddComponents.class })
public class UseFlowLayoutProcessor extends AbstractClassProcessor<UseFlowLayout> {

    @Override
    public void process(Class<?> clazz, Object object, UseFlowLayout annotation) throws LogException {
        if (object instanceof JPanel) {
            JPanel panel = (JPanel) object;
            applyLayout(panel, FlowLayout.class, annotation);
        } else if (object instanceof JFrame) {
            JFrame frame = (JFrame) object;
            applyLayout(frame.getContentPane(), FlowLayout.class, annotation);
        }
    }

    private static void applyLayout(Container container, Class<? extends LayoutManager> layoutClass,
            UseFlowLayout annotation) {
        try {
            int align = annotation.align(), hgap = annotation.hgap(), vgap = annotation.vgap();
            // Crear una instancia del LayoutManager
            Constructor<? extends LayoutManager> constructor = layoutClass.getDeclaredConstructor(int.class, int.class,
                    int.class);
            LayoutManager layoutManager = constructor.newInstance(align, hgap, vgap);
            container.setLayout(layoutManager); // Asignar el layout al contenedor
        } catch (Exception e) {
            e.printStackTrace();
            // En caso de error, podrías optar por un layout por defecto como FlowLayout.
            container.setLayout(new java.awt.FlowLayout());
        }
    }

}
