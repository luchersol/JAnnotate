package io.github.luchersol.processors.mixed.fields_classes.menu;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

import io.github.luchersol.annotations.mixed.fields_classes.menu.AddMenuItems;
import io.github.luchersol.common.abstractClasses.AbstractFieldAndClassProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.common.exceptions.LogException;
import io.github.luchersol.common.exceptions.SevereException;

@JProcessor
public class AddMenuItemsProcessor extends AbstractFieldAndClassProcessor<AddMenuItems> {

    @Override
    protected void process(Field field, Object object, AddMenuItems annotation) throws LogException {
        try {
            JMenu jMenu = getFieldAs(field, object, JMenu.class);
            Set<String> set = new LinkedHashSet<>(Arrays.asList(annotation.value()));

            if (set.isEmpty()) {
                for (Field other : getComponentFields(object.getClass()))
                    if (!other.equals(field) && JMenuItem.class.isAssignableFrom(other.getType()))
                        jMenu.add(getFieldAs(other, object, JMenuItem.class));
            } else
                for (String fieldName : set)
                    if ("-".equals(fieldName))
                        jMenu.add(new JSeparator());
                    else if (isFieldAs(fieldName, object, JMenuItem.class))
                        jMenu.add(getFieldAs(fieldName, object, JMenuItem.class));
        } catch (Exception e) {
            SevereException.throwException(e);
        }
    }

    @Override
    protected void process(Class<?> clazz, Object object, AddMenuItems annotation) throws LogException {
        try {
            JMenu jMenu = (JMenu) object;
            Set<String> set = new LinkedHashSet<>(Arrays.asList(annotation.value()));

            if (set.isEmpty()) {
                for (Field other : getComponentFields(object.getClass()))
                    if (JMenuItem.class.isAssignableFrom(other.getType()))
                        jMenu.add(getFieldAs(other, object, JMenuItem.class));
            } else
                for (String fieldName : set)
                    if ("-".equals(fieldName))
                        jMenu.add(new JSeparator());
                    else if (isFieldAs(fieldName, object, JMenuItem.class))
                        jMenu.add(getFieldAs(fieldName, object, JMenuItem.class));

        } catch (Exception e) {
            SevereException.throwException(e);
        }
    }

}
