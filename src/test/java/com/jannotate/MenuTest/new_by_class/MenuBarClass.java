package com.jannotate.MenuTest.new_by_class;

import com.jannotate.MenuTest.new_by_class.menus.MenuArchivoClass;
import com.jannotate.MenuTest.new_by_class.menus.MenuAyudaClass;
import com.jannotate.MenuTest.new_by_class.menus.MenuEditarClass;
import com.jannotate.annotations.classes.AutoInstantiateFields;
import com.jannotate.annotations.mixed.fields_classes.menu.AddMenus;
import com.jannotate.common.classes.JMenuBar2;

@AddMenus
@AutoInstantiateFields
public class MenuBarClass extends JMenuBar2 {

    MenuArchivoClass menuArchivo;

    MenuEditarClass menuEditar;

    MenuAyudaClass menuAyuda;
}
