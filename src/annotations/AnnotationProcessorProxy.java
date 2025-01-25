package src.annotations;

import java.awt.Container;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.swing.AbstractButton;
import javax.swing.JComponent;

import src.annotations.classes.AutoInstantiateFields;
import src.annotations.fields.ActionComponent;
import src.annotations.fields.ActionsComponent;
import src.annotations.fields.AutoAdd;
import src.annotations.fields.PositionComponent;
import src.annotations.fields.SizeComponent;

public class AnnotationProcessorProxy implements InvocationHandler {
    private final Object target;

    public AnnotationProcessorProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        processAnnotations(target);
        return method.invoke(target);
    }

    private void processAnnotations(Object object) {
        Class<?> clazz = object.getClass();
        processAutoInstance(object, clazz);
        for (Field field : clazz.getDeclaredFields()) {
            processSizeComponent(field, object);
            processPositionComponent(field, object);
            processActionComponent(field, object);
            processActionsComponent(field, object);
            processAutoAdd((Container) object, field);
        }
    }

    private void processAutoInstance(Object object, Class<?> clazz) {
        if (clazz.isAnnotationPresent(AutoInstantiateFields.class)) {
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                try {
                    // Asegurarse de que el campo sea accesible
                    field.setAccessible(true);

                    // Verificar si el campo es null
                    if (field.get(object) == null) {
                        // Obtener el tipo del campo y crear una instancia con el constructor vacío
                        Class<?> fieldType = field.getType();
                        Object instance = fieldType.getDeclaredConstructor().newInstance();
                        field.set(object, instance);
                    }
                } catch (Exception e) {
                    // Manejar errores (por ejemplo, si no hay un constructor vacío o acceso denegado)
                    System.err.println("No se pudo inicializar el campo: " + field.getName());
                }
            }
        }
    }

    private void processAutoAdd(Container container, Field field) {
        if (field.isAnnotationPresent(AutoAdd.class)) {
            field.setAccessible(true);
            try {
                Object value = field.get(container);
                if (value instanceof JComponent) {
                    container.add((JComponent) value);
                } else {
                    throw new IllegalArgumentException("Field annotated with @AutoAdd must be a JComponent.");
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        
    }

    private void processSizeComponent(Field field, Object object) {
        if (field.isAnnotationPresent(SizeComponent.class)) {
            SizeComponent sizeAnnotation = field.getAnnotation(SizeComponent.class);
            field.setAccessible(true);
            try {
                Object value = field.get(object);
                if (value instanceof JComponent) {
                    JComponent component = (JComponent) value;
                    component.setPreferredSize(new java.awt.Dimension(sizeAnnotation.width(), sizeAnnotation.heigth()));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    private void processPositionComponent(Field field, Object object) {
        if (field.isAnnotationPresent(PositionComponent.class)) {
            PositionComponent positionAnnotation = field.getAnnotation(PositionComponent.class);
            field.setAccessible(true);
            try {
                Object value = field.get(object);
                if (value instanceof JComponent) {
                    JComponent component = (JComponent) value;
                    component.setBounds(positionAnnotation.x(), positionAnnotation.y(), component.getWidth(), component.getHeight());
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    private void processActionComponent(Field field, Object object) {
        if (field.isAnnotationPresent(ActionComponent.class)) {
            ActionComponent actionAnnotation = field.getAnnotation(ActionComponent.class);
            processActionComponent(field, object, actionAnnotation);
        }
        
    }

    private void processActionComponent(Field field, Object object, ActionComponent actionAnnotation ) {
        field.setAccessible(true);
        try {
            Object value = field.get(object);
            if (value instanceof AbstractButton) {
                AbstractButton component = (AbstractButton) value;

                // Obtén el nombre del método desde la anotación
                String methodName = actionAnnotation.method();
                Method method = object.getClass().getDeclaredMethod(methodName);
                method.setAccessible(true);

                // Agrega un ActionListener que invoca el método
                component.addActionListener(e -> {
                        try {
                            method.invoke(object);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    
                });
            }
        } catch (IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    private void processActionsComponent(Field field, Object object) {
        if (field.isAnnotationPresent(ActionsComponent.class)) {
            ActionsComponent actionAnnotation = field.getAnnotation(ActionsComponent.class);
            field.setAccessible(true);
            for (ActionComponent actionComponent : actionAnnotation.actions()) {
                processActionComponent(field, object, actionComponent);
            }
        }
        
    }

    public static MyFrameInterface createProxy(Object target) {
        return (MyFrameInterface) Proxy.newProxyInstance(
            target.getClass().getClassLoader(),
            new Class[]{MyFrameInterface.class},  // Cambiar a la interfaz
            new AnnotationProcessorProxy(target)
        );
    }
}