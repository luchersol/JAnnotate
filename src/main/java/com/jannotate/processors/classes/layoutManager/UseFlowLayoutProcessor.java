package com.jannotate.processors.classes.layoutManager;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.lang.reflect.Constructor;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.jannotate.annotations.classes.layoutManager.UseFlowLayout;
import com.jannotate.common.ClassProcessorInterface;
import com.jannotate.common.JProcessor;

@JProcessor
public class UseFlowLayoutProcessor implements ClassProcessorInterface {

    public void process(Class<?> clazz, Object object){        
        if (clazz.isAnnotationPresent(UseFlowLayout.class)) {
            UseFlowLayout annotation = clazz.getAnnotation(UseFlowLayout.class);
            
            // Verificar si el objeto es una instancia de JPanel o JFrame
            if (object instanceof JPanel) {
                JPanel panel = (JPanel) object;
                applyLayout(panel, FlowLayout.class, annotation);
            } else if (object instanceof JFrame) {
                JFrame frame = (JFrame) object;
                applyLayout(frame.getContentPane(), FlowLayout.class, annotation);
            }
        }
    }

    private static void applyLayout(Container container, Class<? extends LayoutManager> layoutClass, UseFlowLayout annotation) {
        try {
            int align = annotation.align(), hgap = annotation.hgap(), vgap = annotation.vgap();
            // Crear una instancia del LayoutManager
            Constructor<? extends LayoutManager> constructor = layoutClass.getDeclaredConstructor(int.class, int.class, int.class);
            LayoutManager layoutManager = constructor.newInstance(align, hgap, vgap);
            container.setLayout(layoutManager);  // Asignar el layout al contenedor
        } catch (Exception e) {
            e.printStackTrace();
            // En caso de error, podrías optar por un layout por defecto como FlowLayout.
            container.setLayout(new java.awt.FlowLayout());
        }
    }
}
