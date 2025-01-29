package com.jannotate.DiferentesComponentes;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.jannotate.annotations.classes.AutoAddComponents;
import com.jannotate.annotations.classes.AutoInstantiateFields;
import com.jannotate.annotations.classes.layoutManager.UseFlowLayout;
import com.jannotate.annotations.fields.listeners.single.ComponentActionListener;
import com.jannotate.annotations.mixed.fields_classes.IsVisible;
import com.jannotate.annotations.mixed.fields_classes.SetSize;
import com.jannotate.annotations.mixed.fields_classes.SetText;
import com.jannotate.annotations.mixed.fields_classes.SetTitle;
import com.jannotate.common.classes.JFrame2;

@UseFlowLayout
@AutoAddComponents
@AutoInstantiateFields
@IsVisible
@SetTitle("Nueva Pantalla")
@SetSize(width = 300, heigth = 150)
public class SecondFrame extends JFrame2 {
    
    @SetText("Esto es una nueva ventana")
    JLabel label;

    @SetText("Cerrar")
    @ComponentActionListener(method = "dispose")
    JButton closeButton;

    public void dispose(){
        super.dispose();
    }

    public SecondFrame() {
        super();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
