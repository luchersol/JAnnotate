package io.github.luchersol.FileChoocerTest.new_by_class;

import java.awt.Component;

import javax.swing.JFileChooser;
import javax.swing.JLabel;

import io.github.luchersol.annotations.mixed.fields_classes.file_chooser.AddFileFilter;
import io.github.luchersol.annotations.mixed.fields_classes.file_chooser.AddFileFilters;
import io.github.luchersol.annotations.mixed.fields_classes.file_chooser.IsMultiSelection;
import io.github.luchersol.annotations.mixed.fields_classes.file_chooser.SetApproveButtonText;
import io.github.luchersol.annotations.mixed.fields_classes.file_chooser.SetCurrentDirectory;
import io.github.luchersol.annotations.mixed.fields_classes.file_chooser.SetFileSelectionMode;
import io.github.luchersol.common.classes.JFileChooser2;

@SetFileSelectionMode(JFileChooser.FILES_ONLY)
@SetApproveButtonText("Seleccionar")

@IsMultiSelection
@SetCurrentDirectory(".")
@AddFileFilters(value = {
        @AddFileFilter(description = "Archivos de Texto", value = { "txt" }),
        @AddFileFilter(description = "Archivos de Imágenes", value = { "jpg" })
}, defaultFilter = "Archivos de Imágenes")
public class FileChooserSecondary extends JFileChooser2 {

    Component parent;
    JLabel fileLabel;

    public FileChooserSecondary(Component parent, JLabel jLabel) {
        super();
        this.parent = parent;
        this.fileLabel = jLabel;
        int result = this.showOpenDialog(parent);
        if (result == JFileChooser.APPROVE_OPTION) {
            fileLabel.setText("Seleccionado: " + this.getSelectedFile().getName());
        } else {
            fileLabel.setText("Ningún archivo seleccionado");
        }

    }

}
