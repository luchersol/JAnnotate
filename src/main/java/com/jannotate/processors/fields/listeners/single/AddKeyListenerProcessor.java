package com.jannotate.processors.fields.listeners.single;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.stream.IntStream;

import javax.swing.JComponent;

import com.jannotate.annotations.fields.listeners.single.AddKeyListener;
import com.jannotate.common.abstractClasses.AbstractListenerProcessor;
import com.jannotate.common.annotations.JProcessor;

@JProcessor
public class AddKeyListenerProcessor extends AbstractListenerProcessor<AddKeyListener> {

    @Override
    public void process(Field field, Object object, AddKeyListener annotation) {
        try {
            JComponent jComponent = getFieldAs(field, object, JComponent.class);
            jComponent.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent event) {
                    try {
                        if (isEmptyOrInclude(annotation.keyTypedParams(), event.getKeyChar())) {
                            processMethodAndArgs(annotation.onKeyType(), object);
                        }
                    } catch (NoSuchMethodException | SecurityException | IllegalAccessException
                            | IllegalArgumentException | InvocationTargetException e) {
                        logger.severe(e.getMessage());
                    }
                }

                @Override
                public void keyPressed(KeyEvent event) {
                    try {
                        if (isEmptyOrInclude(annotation.keyPressedParams(), event.getKeyCode())) {
                            processMethodAndArgs(annotation.onKeyPressed(), object);
                        }
                    } catch (NoSuchMethodException | SecurityException | IllegalAccessException
                            | IllegalArgumentException | InvocationTargetException e) {
                        logger.severe(e.getMessage());
                    }
                }

                @Override
                public void keyReleased(KeyEvent event) {
                    try {
                        if (isEmptyOrInclude(annotation.keyReleasedParams(), event.getKeyCode())) {
                            processMethodAndArgs(annotation.onKeyReleased(), object);
                        }
                    } catch (NoSuchMethodException | SecurityException | IllegalAccessException
                            | IllegalArgumentException | InvocationTargetException e) {
                        logger.severe(e.getMessage());
                    }
                }

            });

        } catch (Exception e) {
            logger.severe(e.getMessage());
        }
    }

    private boolean isEmptyOrInclude(char[] options, char option) {
        return options.length == 0 || IntStream.range(0, options.length)
                .anyMatch(i -> options[i] == option);
    }

    private boolean isEmptyOrInclude(int[] options, int option) {
        return options.length == 0 || Arrays.stream(options).anyMatch(i -> i == option);
    }

}
