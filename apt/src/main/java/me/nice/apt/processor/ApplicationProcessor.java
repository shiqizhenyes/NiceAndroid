package me.nice.apt.processor;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.ElementFilter;

import me.nice.annotation.apt.ApplicationConfig;
import me.nice.apt.AnnotationProcessor;
import me.nice.apt.inter.IProcessor;

public class ApplicationProcessor implements IProcessor {

    @Override
    public void process(AnnotationProcessor annotationProcessor, RoundEnvironment roundEnv) {

        String className = "ApplicationConfigs";
        TypeSpec.Builder typeBuilder = TypeSpec.classBuilder(className);
        typeBuilder.addModifiers(Modifier.PUBLIC);
        typeBuilder.addJavadoc("@ 此类是由apt自动生成，请勿修改");
        FieldSpec fieldSpec;
        String fieldNames = "";
        String fieldValue = "";

        for (TypeElement element : ElementFilter.typesIn(roundEnv.getElementsAnnotatedWith(ApplicationConfig.class))) {
            ClassName clazzName = ClassName.get(element);

            if (fieldNames.equals("")) {
                fieldNames = clazzName.simpleName();
            }else {
                fieldNames = fieldNames + "," + clazzName.simpleName();
            }
            if (fieldValue.equals("")) {
                fieldValue = clazzName.toString();
            }else {
                fieldValue = fieldValue + "," + clazzName;
            }

            System.out.println("zack " + clazzName);

        }

        System.out.println("zack " + fieldNames);

        String[] names = fieldNames.split(",");
        String[] values = fieldValue.split(",");

        String configs = "CONFIGS";

//        for (int i = 0; i < names.length; i++) {
//
//            fieldSpec = FieldSpec.builder(String.class, names[i], Modifier.PUBLIC, Modifier.STATIC)
//                    .initializer("$S", values[i]).build();
//
//            typeBuilder.addField(fieldSpec);
//        }

//        fieldSpec = FieldSpec.builder(String[].class,configs, Modifier.PUBLIC, Modifier.STATIC)
//                .initializer("{$L}", fieldNames).build();

//        fieldSpec.toBuilder().initializer("{$L}", fieldNames);
//        typeBuilder.addField(fieldSpec);
        JavaFile javaFile = JavaFile.builder("com.apt", typeBuilder.build()).build();
        String path = "app/build/generated/source/apt/debug";
        Path outPath = Paths.get(path);
        try {
            javaFile.writeTo(outPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
