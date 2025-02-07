package com.jannotate.MenuTest.new_by_class;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.jannotate.annotations.classes.AutoInstantiateFields;
import com.jannotate.annotations.classes.layoutManager.UseFlowLayout;
import com.jannotate.annotations.fields.AutoAdd;
import com.jannotate.annotations.mixed.fields_classes.IsVisible;
import com.jannotate.annotations.mixed.fields_classes.SetDefaultClose;
import com.jannotate.annotations.mixed.fields_classes.SetJMenuBar;
import com.jannotate.annotations.mixed.fields_classes.SetLocationRelativeTo;
import com.jannotate.annotations.mixed.fields_classes.SetSize;
import com.jannotate.annotations.mixed.fields_classes.SetText;
import com.jannotate.annotations.mixed.fields_classes.SetTitle;
import com.jannotate.common.classes.JFrame2;

@UseFlowLayout
@AutoInstantiateFields
@IsVisible
@SetSize(width = 500, heigth = 400)
@SetDefaultClose(JFrame.EXIT_ON_CLOSE)
@SetTitle("Ejemplo de Menú en JFrame")
@SetJMenuBar("menuBar")
@SetLocationRelativeTo
public class MenuMainClass extends JFrame2 {

    MenuBarClass menuBar;

    @AutoAdd
    @SetText("¡Bienvenido al ejemplo de menú en Swing!")
    JLabel label;

    public static void main(String[] args) {
        new MenuMainClass();

    }

}
