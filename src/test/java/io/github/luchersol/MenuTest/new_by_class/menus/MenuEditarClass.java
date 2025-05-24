package io.github.luchersol.MenuTest.new_by_class.menus;

import javax.swing.JMenuItem;

import io.github.luchersol.annotations.classes.AutoInstantiateFields;
import io.github.luchersol.annotations.mixed.fields_classes.SetText;
import io.github.luchersol.annotations.mixed.fields_classes.menu.AddMenuItems;
import io.github.luchersol.common.classes.JMenu2;

@SetText("Editar")
@AddMenuItems
@AutoInstantiateFields
public class MenuEditarClass extends JMenu2 {

    @SetText("Copiar")
    JMenuItem itemCopiar;

    @SetText("Pegar")
    JMenuItem itemPegar;

}
