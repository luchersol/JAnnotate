package io.github.luchersol.processors.mixed.fields_classes.menu;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JSeparator;

import io.github.luchersol.annotations.mixed.fields_classes.menu.AddMenus;
import io.github.luchersol.common.abstractClasses.AbstractFieldAndClassProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.common.exceptions.LogException;
import io.github.luchersol.common.exceptions.SevereException;

@JProcessor
public class AddMenusProcessor extends AbstractFieldAndClassProcessor<AddMenus> {

    @Override
    public void process(Field field, Object object, AddMenus annotation) throws LogException {
        try {
            JMenuBar jMenuBar = getFieldAs(field, object, JMenuBar.class);
            Set<String> set = new HashSet<>(Arrays.asList(annotation.value()));
            if (set.isEmpty()) {
                for (Field other : getComponentFields(object.getClass()))
                    if (!other.equals(field) && JMenu.class.isAssignableFrom(other.getType()))
                        jMenuBar.add(getFieldAs(other, object, JMenu.class));
            } else {
                for (String fieldName : set) {
                    if ("-".equals(fieldName))
                        jMenuBar.add(new JSeparator());
                    else {
                        getFieldAs(fieldName, object, JMenu.class);
                    }
                }
            }

        } catch (Exception e) {
            SevereException.throwException(e);
        }
    }

    @Override
    public void process(Class<?> clazz, Object object, AddMenus annotation) throws LogException {
        try {
            JMenuBar jMenuBar = (JMenuBar) object;
            Set<String> set = new HashSet<>(Arrays.asList(annotation.value()));

            if (set.isEmpty()) {
                for (Field other : getComponentFields(object.getClass()))
                    if (JMenu.class.isAssignableFrom(other.getType()))
                        jMenuBar.add(getFieldAs(other, object, JMenu.class));
            } else
                for (String fieldName : set)
                    if ("-".equals(fieldName))
                        jMenuBar.add(new JSeparator());
                    else
                        jMenuBar.add(getFieldAs(fieldName, object, JMenu.class));

        } catch (Exception e) {
            SevereException.throwException(e);
        }
    }

}
