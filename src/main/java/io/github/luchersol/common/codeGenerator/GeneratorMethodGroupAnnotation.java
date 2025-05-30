package io.github.luchersol.common.codeGenerator;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Set;

import javax.lang.model.element.Modifier;

import org.reflections.Reflections;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ArrayTypeName;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

public class GeneratorMethodGroupAnnotation {

        private static final String INPUT_PACKAGE = "io.github.luchersol.annotations.methods.handlers.single";
        private static final String OUTPUT_DIRECTORY = "src/main/java";

        public static void main(String[] args) throws IOException {
                Reflections reflections = new Reflections(INPUT_PACKAGE);
                Set<Class<?>> annotations = reflections.getTypesAnnotatedWith(Target.class);

                for (Class<?> annotationClass : annotations) {
                        if (!annotationClass.isAnnotation())
                                continue;

                        String singularName = annotationClass.getSimpleName();
                        String pluralName = singularName + "s";

                        // Crear la anotación contenedora plural
                        AnnotationSpec target = AnnotationSpec.builder(Target.class)
                                        .addMember("value", "$T.METHOD", ElementType.class)
                                        .build();

                        AnnotationSpec retention = AnnotationSpec.builder(Retention.class)
                                        .addMember("value", "$T.RUNTIME", RetentionPolicy.class)
                                        .build();

                        ArrayTypeName containedArray = ArrayTypeName.of(ClassName.get(annotationClass));

                        TypeSpec containerAnnotation = TypeSpec.annotationBuilder(pluralName)
                                        .addModifiers(Modifier.PUBLIC)
                                        .addAnnotation(target)
                                        .addAnnotation(retention)
                                        .addMethod(MethodSpec.methodBuilder("value")
                                                        .addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT)
                                                        .returns(containedArray)
                                                        .defaultValue("{}")
                                                        .build())
                                        .build();

                        String outputPackage = annotationClass.getPackage().getName().replace("single", "group");
                        JavaFile javaFile = JavaFile.builder(outputPackage, containerAnnotation)
                                        .build();

                        javaFile.writeTo(new File(OUTPUT_DIRECTORY));
                        System.out.println("Generado: " + pluralName + ".java");
                }
        }
}
