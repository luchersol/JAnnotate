package io.github.luchersol.MenuTest.new_by_class;

import io.github.luchersol.MenuTest.new_by_class.menus.MenuArchivoClass;
import io.github.luchersol.MenuTest.new_by_class.menus.MenuAyudaClass;
import io.github.luchersol.MenuTest.new_by_class.menus.MenuEditarClass;
import io.github.luchersol.annotations.classes.AutoInstantiateFields;
import io.github.luchersol.annotations.mixed.fields_classes.menu.AddMenus;
import io.github.luchersol.common.classes.JMenuBar2;

@AddMenus
@AutoInstantiateFields
public class MenuBarClass extends JMenuBar2 {

    MenuArchivoClass menuArchivo;

    MenuEditarClass menuEditar;

    MenuAyudaClass menuAyuda;
}
