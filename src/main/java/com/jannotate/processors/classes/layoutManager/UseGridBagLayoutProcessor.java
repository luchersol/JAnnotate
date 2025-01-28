package com.jannotate.processors.classes.layoutManager;

import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.lang.reflect.Constructor;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.jannotate.annotations.classes.layoutManager.UseGridBagLayout;
import com.jannotate.common.ClassProcessorInterface;
import com.jannotate.common.JProcessor;

@JProcessor
public class UseGridBagLayoutProcessor implements ClassProcessorInterface {

    public void process(Class<?> clazz, Object object){        
        if (clazz.isAnnotationPresent(UseGridBagLayout.class)) {
            // Verificar si el objeto es una instancia de JPanel o JFrame
            if (object instanceof JPanel) {
                JPanel panel = (JPanel) object;
                applyLayout(panel, GridBagLayout.class);
            } else if (object instanceof JFrame) {
                JFrame frame = (JFrame) object;
                applyLayout(frame.getContentPane(), GridBagLayout.class);
            }
        }
    }

    private static void applyLayout(Container container, Class<? extends LayoutManager> layoutClass) {
        try {
            // Crear una instancia del LayoutManager
            Constructor<? extends LayoutManager> constructor = layoutClass.getDeclaredConstructor();
            LayoutManager layoutManager = constructor.newInstance();
            container.setLayout(layoutManager);  // Asignar el layout al contenedor
        } catch (Exception e) {
            e.printStackTrace();
            // En caso de error, podrías optar por un layout por defecto como FlowLayout.
            container.setLayout(new java.awt.FlowLayout());
        }
    }
}
