package io.github.luchersol.MenuTest.new_by_class.menus;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import io.github.luchersol.annotations.classes.AutoInstantiateFields;
import io.github.luchersol.annotations.fields.SetAccelerator;
import io.github.luchersol.annotations.fields.listeners.single.AddActionListener;
import io.github.luchersol.annotations.mixed.fields_classes.SetText;
import io.github.luchersol.annotations.mixed.fields_classes.menu.AddMenuItems;
import io.github.luchersol.common.classes.JMenu2;

@SetText("Archivo")
@AddMenuItems({ "itemAbrir", "itemGuardar", "-", "itemSalir" })
@AutoInstantiateFields
public class MenuArchivoClass extends JMenu2 {

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

    public void f_abrir() {
        JOptionPane.showMessageDialog(this, "Abrir archivo...");
    }

    public void f_guardar() {
        JOptionPane.showMessageDialog(this, "Guardar archivo...");
    }

    public void f_salir() {
        System.exit(0);
    }
}
