package io.github.luchersol.MenuTest.new_in_one;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import io.github.luchersol.annotations.classes.AutoInstantiateFields;
import io.github.luchersol.annotations.classes.layoutManager.UseFlowLayout;
import io.github.luchersol.annotations.fields.AutoAdd;
import io.github.luchersol.annotations.fields.SetAccelerator;
import io.github.luchersol.annotations.fields.listeners.single.AddActionListener;
import io.github.luchersol.annotations.mixed.fields_classes.IsVisible;
import io.github.luchersol.annotations.mixed.fields_classes.SetDefaultClose;
import io.github.luchersol.annotations.mixed.fields_classes.SetLocationRelativeTo;
import io.github.luchersol.annotations.mixed.fields_classes.SetSize;
import io.github.luchersol.annotations.mixed.fields_classes.SetText;
import io.github.luchersol.annotations.mixed.fields_classes.SetTitle;
import io.github.luchersol.annotations.mixed.fields_classes.menu.AddMenuItems;
import io.github.luchersol.annotations.mixed.fields_classes.menu.AddMenus;
import io.github.luchersol.annotations.mixed.fields_classes.menu.SetJMenuBar;
import io.github.luchersol.common.classes.JFrame2;

@UseFlowLayout
@AutoInstantiateFields
@IsVisible
@SetSize(width = 500, heigth = 400)
@SetDefaultClose(JFrame.EXIT_ON_CLOSE)
@SetTitle("Ejemplo de Menú en JFrame")
@SetJMenuBar("menuBar")
@SetLocationRelativeTo
public class MenuTestInOne extends JFrame2 {

    @AddMenus
    JMenuBar menuBar;

    @SetText("Archivo")
    @AddMenuItems({ "itemAbrir", "itemGuardar", "-", "itemSalir" })
    JMenu menuArchivo;

    @SetText("Abrir")
    @AddActionListener("f_abrir")
    @SetAccelerator("ctrl O")
    JMenuItem itemAbrir;

    @SetText("Guardar")
    @AddActionListener("f_guardar")
    @SetAccelerator("ctrl S")
    JMenuItem itemGuardar;

    @SetText("Salir")
    @AddActionListener("f_salir")
    @SetAccelerator("ctrl Q")
    JMenuItem itemSalir;

    @SetText("Editar")
    @AddMenuItems({ "itemCopiar", "itemPegar" })
    JMenu menuEditar;

    @SetText("Copiar")
    JMenuItem itemCopiar;

    @SetText("Pegar")
    JMenuItem itemPegar;

    @AutoAdd
    @SetText("¡Bienvenido al ejemplo de menú en Swing!")
    JLabel label;

    @SetText("Ayuda")
    @AddMenuItems({ "itemAcercaDe" })
    JMenu menuAyuda;

    @SetText("Acerca")
    @AddActionListener("f_acerca_de")
    JMenuItem itemAcercaDe;

    public void f_abrir() {
        JOptionPane.showMessageDialog(this, "Abrir archivo...");
    }

    public void f_guardar() {
        JOptionPane.showMessageDialog(this, "Guardar archivo...");
    }

    public void f_salir() {
        System.exit(0);
    }

    public void f_acerca_de() {
        JOptionPane.showMessageDialog(this, "Ejemplo de menú en Swing\nVersión 1.0");
    }

    public static void main(String[] args) {
        new MenuTestInOne();
    }

}
