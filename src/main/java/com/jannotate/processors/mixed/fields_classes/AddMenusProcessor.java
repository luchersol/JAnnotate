package com.jannotate.processors.mixed.fields_classes;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JSeparator;

import com.jannotate.annotations.mixed.fields_classes.AddMenus;
import com.jannotate.common.abstractClasses.AbstractFieldAndClassProcessor;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.common.exceptions.LogException;
import com.jannotate.common.exceptions.SevereException;

@JProcessor
public class AddMenusProcessor extends AbstractFieldAndClassProcessor<AddMenus> {

    @Override
    protected void process(Field field, Object object, AddMenus annotation) throws LogException {
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
            SevereException.throw_exception(e);
        }
    }

    @Override
    protected void process(Class<?> clazz, Object object, AddMenus annotation) throws LogException {
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
            SevereException.throw_exception(e);
        }
    }

}
