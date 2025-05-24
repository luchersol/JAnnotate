package io.github.luchersol.FileChoocerTest.new_by_class;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import io.github.luchersol.annotations.classes.AutoAddComponents;
import io.github.luchersol.annotations.classes.AutoInstantiateFields;
import io.github.luchersol.annotations.classes.layoutManager.UseFlowLayout;
import io.github.luchersol.annotations.fields.listeners.single.AddActionListener;
import io.github.luchersol.annotations.mixed.fields_classes.IsVisible;
import io.github.luchersol.annotations.mixed.fields_classes.SetDefaultClose;
import io.github.luchersol.annotations.mixed.fields_classes.SetLocationRelativeTo;
import io.github.luchersol.annotations.mixed.fields_classes.SetSize;
import io.github.luchersol.annotations.mixed.fields_classes.SetText;
import io.github.luchersol.annotations.mixed.fields_classes.SetTitle;
import io.github.luchersol.common.classes.JFrame2;

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
