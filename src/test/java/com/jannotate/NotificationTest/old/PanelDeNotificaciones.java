package com.jannotate.NotificationTest.old;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class PanelDeNotificaciones extends JFrame {

    public PanelDeNotificaciones() {
        setTitle("Panel de Notificaciones");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Layout con espacios
        setLayout(new GridLayout(5, 1, 10, 10));

        // Botones para cada tipo de notificación
        add(crearBoton("Mostrar Información", JOptionPane.INFORMATION_MESSAGE, "Este es un mensaje de información"));
        add(crearBoton("Mostrar Advertencia", JOptionPane.WARNING_MESSAGE, "Este es un mensaje de advertencia"));
        add(crearBoton("Mostrar Error", JOptionPane.ERROR_MESSAGE, "Este es un mensaje de error"));
        add(crearBoton("Mostrar Pregunta", JOptionPane.QUESTION_MESSAGE, "¿Deseas continuar?"));
        add(crearBoton("Mostrar Plano", JOptionPane.PLAIN_MESSAGE, "Mensaje plano sin icono"));

        setVisible(true);
    }

    private JButton crearBoton(String texto, int tipo, String mensaje) {
        JButton boton = new JButton(texto);
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, mensaje, texto, tipo);
            }
        });
        return boton;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PanelDeNotificaciones());
    }
}
