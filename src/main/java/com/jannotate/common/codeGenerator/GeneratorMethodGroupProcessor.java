package com.jannotate.common.codeGenerator;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Set;

import javax.lang.model.element.Modifier;

import org.reflections.Reflections;

import com.jannotate.common.annotations.JProcessor;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeSpec;

public class GeneratorMethodGroupProcessor {
    private static final String INPUT_PACKAGE = "com.jannotate.processors.methods.handlers.single";
    private static final String OUTPUT_DIRECTORY = "src/main/java";

    public static void main(String[] args) throws IOException {
        Reflections reflections = new Reflections(INPUT_PACKAGE);
        Set<Class<?>> processorClasses = reflections.getTypesAnnotatedWith(JProcessor.class);

        for (Class<?> processorClass : processorClasses) {
            if (!processorClass.getSimpleName().endsWith("Processor"))
                continue;

            Type genericSuperclass = processorClass.getGenericSuperclass();
            if (!(genericSuperclass instanceof ParameterizedType))
                continue;

            ParameterizedType parameterized = (ParameterizedType) genericSuperclass;
            if (parameterized.getActualTypeArguments().length != 2)
                continue;

            Class<?> annotationClass = (Class<?>) parameterized.getActualTypeArguments()[0];
            Class<?> listenerClass = (Class<?>) parameterized.getActualTypeArguments()[1];

            String baseName = processorClass.getSimpleName().replace("Processor", "");
            String pluralName = baseName + "s";

            // Nombres de clases
            ClassName originalProcessor = ClassName.get(processorClass);
            ClassName singleAnnotation = ClassName.get(annotationClass);
            String groupPackage = singleAnnotation.packageName().replace("single", "group");
            String groupSimpleName = singleAnnotation.simpleName() + "s";
            ClassName groupAnnotation = ClassName.get(groupPackage, groupSimpleName);

            String outputPackage = processorClass.getPackage().getName().replace("single", "group");

            // Clase base agrupadora (ajusta si tienes otras variantes)
            ClassName superClassRaw = ClassName.get("com.jannotate.common.abstractClasses",
                    "AbstractGroupedListenerHandlerProcessor");
            ParameterizedTypeName superClass = ParameterizedTypeName.get(
                    superClassRaw,
                    originalProcessor, singleAnnotation, groupAnnotation);

            String nameFile = pluralName + "Processor";
            TypeSpec groupedProcessor = TypeSpec.classBuilder(nameFile)
                    .addModifiers(Modifier.PUBLIC)
                    .superclass(superClass)
                    .addAnnotation(ClassName.get(JProcessor.class))
                    .build();

            JavaFile javaFile = JavaFile.builder(outputPackage, groupedProcessor)
                    .build();

            javaFile.writeTo(new File(OUTPUT_DIRECTORY));
            System.out.println("Generado: " + nameFile + ".java");
        }
    }
}
