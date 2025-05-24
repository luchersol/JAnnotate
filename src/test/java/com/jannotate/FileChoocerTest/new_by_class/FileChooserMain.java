package com.jannotate.FileChoocerTest.new_by_class;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.jannotate.annotations.classes.AutoAddComponents;
import com.jannotate.annotations.classes.AutoInstantiateFields;
import com.jannotate.annotations.classes.layoutManager.UseFlowLayout;
import com.jannotate.annotations.fields.listeners.single.AddActionListener;
import com.jannotate.annotations.mixed.fields_classes.IsVisible;
import com.jannotate.annotations.mixed.fields_classes.SetDefaultClose;
import com.jannotate.annotations.mixed.fields_classes.SetLocationRelativeTo;
import com.jannotate.annotations.mixed.fields_classes.SetSize;
import com.jannotate.annotations.mixed.fields_classes.SetText;
import com.jannotate.annotations.mixed.fields_classes.SetTitle;
import com.jannotate.common.classes.JFrame2;

@SetTitle("JFileChooser Demo")
@SetSize(width = 400, heigth = 200)
@SetDefaultClose(JFrame.EXIT_ON_CLOSE)
@SetLocationRelativeTo
@UseFlowLayout
@AutoAddComponents
@AutoInstantiateFields
@IsVisible
public class FileChooserMain extends JFrame2 {

    @SetText("Seleccionar Archivo")
    @AddActionListener("openFileChooser")
    JButton openButton;

    @SetText("Archivo seleccionado: Ninguno")
    JLabel fileLabel;

    void openFileChooser() {
        new FileChooserSecondary(this, fileLabel);
    }

    public static void main(String[] args) {
        new FileChooserMain();
    }

}
