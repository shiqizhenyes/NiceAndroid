package me.nice.apt.processor;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.ElementFilter;

import me.nice.annotation.apt.InstanceFactory;
import me.nice.apt.AnnotationProcessor;
import me.nice.apt.inter.IProcessor;

public class InstanceProcessor implements IProcessor {

    @Override
    public void process(AnnotationProcessor annotationProcessor, RoundEnvironment roundEnv) {
        String className1 = "PresenterFactory";
        TypeSpec.Builder typeBuilder = TypeSpec.classBuilder(className1);
        typeBuilder.addModifiers(Modifier.PUBLIC);
        typeBuilder.addJavadoc("@ 此类是由apt自动生成，请勿修改");
        String methodName = "onCreate";
        MethodSpec.Builder methodSpecBuilder = MethodSpec.methodBuilder(methodName)
                .addModifiers(Modifier.PUBLIC)
                .addModifiers(Modifier.STATIC)
                .addParameter(Class.class, "mClass")
                .returns(Object.class)
                .addException(IllegalAccessException.class)
                .addException(InstantiationException.class);
        CodeBlock.Builder codeBlockBuilder = CodeBlock.builder();
        codeBlockBuilder.beginControlFlow("switch (mClass.getSimpleName())");
        for (TypeElement element : ElementFilter.typesIn(roundEnv.getElementsAnnotatedWith(InstanceFactory.class))) {
            ClassName className = ClassName.get(element);
            codeBlockBuilder.addStatement("case $S: \n return new $T()", className.simpleName(), className );
        }
        codeBlockBuilder.addStatement("default:\n return mClass");
        codeBlockBuilder.endControlFlow();
        methodSpecBuilder.addCode(codeBlockBuilder.build());
        typeBuilder.addMethod(methodSpecBuilder.build());
        JavaFile javaFile = JavaFile.builder("com.apt",typeBuilder.build()).build();
        String path = "base/build/generated/source/apt";
        Path outPath = Paths.get(path);
        try {
            javaFile.writeTo(outPath);
//            javaFile.writeTo(annotationProcessor.getFiler());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
