package com.jannotate.processors.classes.layoutManager;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.LayoutManager;
import java.lang.reflect.Constructor;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.jannotate.annotations.classes.layoutManager.UseCardLayout;
import com.jannotate.common.ClassProcessor;

public class UseCardLayoutProcessor implements ClassProcessor{

    public void process(Object object, Class<?> clazz){        
        if (clazz.isAnnotationPresent(UseCardLayout.class)) {
            UseCardLayout annotation = clazz.getAnnotation(UseCardLayout.class);
            
            // Verificar si el objeto es una instancia de JPanel o JFrame
            if (object instanceof JPanel) {
                JPanel panel = (JPanel) object;
                applyLayout(panel, CardLayout.class, annotation);
            } else if (object instanceof JFrame) {
                JFrame frame = (JFrame) object;
                applyLayout(frame.getContentPane(), CardLayout.class, annotation);
            }
        }
    }

    private static void applyLayout(Container container, Class<? extends LayoutManager> layoutClass, UseCardLayout annotation) {
        try {
            int hgap = annotation.hgap(), vgap = annotation.vgap();
            // Crear una instancia del LayoutManager
            Constructor<? extends LayoutManager> constructor = layoutClass.getDeclaredConstructor(int.class, int.class);
            LayoutManager layoutManager = constructor.newInstance(hgap, vgap);
            container.setLayout(layoutManager);  // Asignar el layout al contenedor
        } catch (Exception e) {
            e.printStackTrace();
            // En caso de error, podrías optar por un layout por defecto como FlowLayout.
            container.setLayout(new java.awt.FlowLayout());
        }
    }
}
