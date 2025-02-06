package com.jannotate.DiferentesComponentes;

import javax.swing.JButton;
import javax.swing.JTextField;

import com.jannotate.annotations.classes.AutoAddComponents;
import com.jannotate.annotations.classes.AutoInstantiateFields;
import com.jannotate.annotations.classes.layoutManager.UseFlowLayout;
import com.jannotate.annotations.fields.listeners.single.AddActionListener;
import com.jannotate.annotations.mixed.fields_classes.IsVisible;
import com.jannotate.annotations.mixed.fields_classes.SetColumns;
import com.jannotate.annotations.mixed.fields_classes.SetSize;
import com.jannotate.annotations.mixed.fields_classes.SetText;
import com.jannotate.annotations.mixed.fields_classes.SetTitle;
import com.jannotate.common.classes.JFrame2;

@UseFlowLayout
@AutoAddComponents
@AutoInstantiateFields
@IsVisible
@SetTitle("Ventana Principal")
@SetSize(width = 400, heigth = 200)
public class MainFrame extends JFrame2 {

    @SetColumns(20)
    JTextField textField;

    @AddActionListener("openNewWindow")
    @SetText("Abrir nueva pantalla")
    JButton button;

    public static void main(String[] args) {
        new MainFrame();
    }

    public void openNewWindow() {
        new SecondFrame();
    }
}
