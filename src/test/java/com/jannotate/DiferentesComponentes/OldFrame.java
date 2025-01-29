package com.jannotate.DiferentesComponentes;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OldFrame {
    public static void main(String[] args) {
        JFrame oldFrame = new JFrame("Ventana Principal");
        oldFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        oldFrame.setSize(400, 200);
        oldFrame.setLayout(new FlowLayout());

        JTextField textField = new JTextField(20);

        JButton button = new JButton("Abrir nueva pantalla");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openNewWindow();
            }
        });

        oldFrame.add(textField);
        oldFrame.add(button);

        oldFrame.setVisible(true);
    }

    private static void openNewWindow() {
        JFrame newFrame = new JFrame("Nueva Pantalla");
        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newFrame.setSize(300, 150);
        newFrame.setLayout(new FlowLayout());

        JLabel label = new JLabel("Esto es una nueva ventana");
        JButton closeButton = new JButton("Cerrar");

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newFrame.dispose();
            }
        });

        newFrame.add(label);
        newFrame.add(closeButton);

        newFrame.setVisible(true);
    }
}
