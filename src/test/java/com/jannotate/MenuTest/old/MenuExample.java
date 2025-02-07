package com.jannotate.MenuTest.old;

import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class MenuExample extends JFrame {

    public MenuExample() {
        setTitle("Ejemplo de Menú en JFrame");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana

        // Crear la barra de menú
        JMenuBar menuBar = new JMenuBar();

        // Menú "Archivo"
        JMenu menuArchivo = new JMenu("Archivo");
        JMenuItem itemAbrir = new JMenuItem("Abrir");
        JMenuItem itemGuardar = new JMenuItem("Guardar");
        JMenuItem itemSalir = new JMenuItem("Salir");

        // Atajos de teclado
        itemAbrir.setAccelerator(KeyStroke.getKeyStroke('O', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        itemGuardar.setAccelerator(KeyStroke.getKeyStroke('S', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        itemSalir.setAccelerator(KeyStroke.getKeyStroke('Q', Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));

        // Eventos de los ítems de menú
        itemAbrir.addActionListener(e -> JOptionPane.showMessageDialog(this, "Abrir archivo..."));
        itemGuardar.addActionListener(e -> JOptionPane.showMessageDialog(this, "Guardar archivo..."));
        itemSalir.addActionListener(e -> System.exit(0));

        // Agregar elementos al menú "Archivo"
        menuArchivo.add(itemAbrir);
        menuArchivo.add(itemGuardar);
        menuArchivo.addSeparator(); // Separador visual
        menuArchivo.add(itemSalir);

        // Menú "Editar"
        JMenu menuEditar = new JMenu("Editar");
        JMenuItem itemCopiar = new JMenuItem("Copiar");
        JMenuItem itemPegar = new JMenuItem("Pegar");
        menuEditar.add(itemCopiar);
        menuEditar.add(itemPegar);

        // Menú "Ayuda"
        JMenu menuAyuda = new JMenu("Ayuda");
        JMenuItem itemAcercaDe = new JMenuItem("Acerca de");
        itemAcercaDe
                .addActionListener(e -> JOptionPane.showMessageDialog(this, "Ejemplo de menú en Swing\nVersión 1.0"));
        menuAyuda.add(itemAcercaDe);

        // Agregar los menús a la barra de menú
        menuBar.add(menuArchivo);
        menuBar.add(menuEditar);
        menuBar.add(menuAyuda);

        // Asignar la barra de menú al JFrame
        setJMenuBar(menuBar);

        // Configurar layout y componentes adicionales
        setLayout(new FlowLayout());
        JLabel label = new JLabel("¡Bienvenido al ejemplo de menú en Swing!");
        add(label);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MenuExample().setVisible(true));
    }
}
