package com.jannotate.FileChoocerTest.new_in_one;

import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

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
public class FileChooserInOne extends JFrame2 {

    @SetText("Seleccionar Archivo")
    @AddActionListener("openFileChooser")
    JButton openButton;

    @SetText("Archivo seleccionado: Ninguno")
    JLabel fileLabel;

    void openFileChooser() {
        JFileChooser fileChooser = new JFileChooser();

        // 📌 Configurar para permitir solo la selección de archivos (No directorios)
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        // 📌 Aplicar un filtro para mostrar solo archivos .txt y .jpg
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de Texto e Imágenes", "txt", "jpg");
        fileChooser.setFileFilter(filter);

        // 📌 Cambiar el texto del botón "Abrir" a "Seleccionar"
        fileChooser.setApproveButtonText("Seleccionar");

        // 📌 Mostrar el JFileChooser en el centro de la ventana principal
        int result = fileChooser.showOpenDialog(this);

        // 📌 Verificar si el usuario seleccionó un archivo
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            fileLabel.setText("Seleccionado: " + selectedFile.getName());
        } else {
            fileLabel.setText("Ningún archivo seleccionado");
        }
    }

    public static void main(String[] args) {
        new FileChooserInOne();
    }

}
