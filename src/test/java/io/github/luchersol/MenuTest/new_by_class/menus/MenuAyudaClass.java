package io.github.luchersol.MenuTest.new_by_class.menus;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import io.github.luchersol.annotations.classes.AutoInstantiateFields;
import io.github.luchersol.annotations.fields.listeners.single.AddActionListener;
import io.github.luchersol.annotations.mixed.fields_classes.SetText;
import io.github.luchersol.annotations.mixed.fields_classes.menu.AddMenuItems;
import io.github.luchersol.common.classes.JMenu2;

@SetText("Ayuda")
@AddMenuItems
@AutoInstantiateFields
public class MenuAyudaClass extends JMenu2 {

    @SetText("Acerca")
    @AddActionListener("f_acerca_de")
    JMenuItem itemAcercaDe;

    public void f_acerca_de() {
        JOptionPane.showMessageDialog(this, "Ejemplo de menú en Swing\nVersión 1.0");
    }
}
