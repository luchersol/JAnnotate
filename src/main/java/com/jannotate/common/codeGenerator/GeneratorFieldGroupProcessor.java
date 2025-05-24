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

public class GeneratorFieldGroupProcessor {

    private static final String INPUT_PACKAGE = "com.jannotate.processors.fields.listeners.single";
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
            if (parameterized.getActualTypeArguments().length < 1)
                continue;

            String baseName = processorClass.getSimpleName().replace("Processor", "");
            String pluralName = baseName + "s";

            // Crear nombres de clases y paquete
            ClassName originalProcessor = ClassName.get(processorClass);
            ClassName singleAnnotation = ClassName
                    .bestGuess(((Class<?>) parameterized.getActualTypeArguments()[0]).getName());
            ClassName groupAnnotation = ClassName.bestGuess(
                    singleAnnotation.packageName().replace("single", "group") + "." + pluralName);

            String outputPackage = processorClass.getPackage().getName().replace("single", "group");

            // Definir tipo del nuevo processor agrupado
            ParameterizedTypeName superClass = ParameterizedTypeName.get(
                    ClassName.get("com.jannotate.common.abstractClasses", "AbstractGroupedListenerProcessor"),
                    originalProcessor, singleAnnotation, groupAnnotation);

            TypeSpec groupedProcessor = TypeSpec.classBuilder(pluralName + "Processor")
                    .addModifiers(Modifier.PUBLIC)
                    .superclass(superClass)
                    .addAnnotation(ClassName.get("com.jannotate.common.annotations", "JProcessor"))
                    .build();

            JavaFile javaFile = JavaFile.builder(outputPackage, groupedProcessor)
                    .build();

            javaFile.writeTo(new File(OUTPUT_DIRECTORY));
            System.out.println("Generado: " + pluralName + "Processor.java");
        }
    }
}
