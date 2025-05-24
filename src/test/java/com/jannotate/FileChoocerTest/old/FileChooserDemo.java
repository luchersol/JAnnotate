package com.jannotate.FileChoocerTest.old;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileChooserDemo extends JFrame {
    private JButton openButton;
    private JLabel fileLabel;

    public FileChooserDemo() {
        setTitle("JFileChooser Demo");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        openButton = new JButton("Seleccionar Archivo");
        fileLabel = new JLabel("Archivo seleccionado: Ninguno");

        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFileChooser();
            }
        });

        panel.add(openButton);
        panel.add(fileLabel);
        add(panel);

        setVisible(true);
    }

    private void openFileChooser() {
        JFileChooser fileChooser = new JFileChooser();

        // 📌 Configurar para permitir solo la selección de archivos (No directorios)
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        // 📌 Aplicar un filtro para mostrar solo archivos .txt y .jpg
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de Texto e Imágenes", "txt", "jpg");
        fileChooser.setFileFilter(filter);
        fileChooser.setMultiSelectionEnabled(true);

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
        SwingUtilities.invokeLater(() -> new FileChooserDemo());
    }
}
