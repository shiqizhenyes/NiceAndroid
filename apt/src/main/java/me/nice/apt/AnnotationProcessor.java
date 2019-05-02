package me.nice.apt;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;

import me.nice.apt.processor.InstanceProcessor;
import mobi.zack.aap.annotation.AutoProcessorFactory;

@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedAnnotationTypes({"me.nice.annotation.apt.InstanceFactory"})
@AutoProcessorFactory(AnnotationProcessor.class)
public class AnnotationProcessor extends AbstractProcessor {

    private Filer filer;

    public Filer getFiler() {
        return filer;
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        filer = processingEnv.getFiler();
        new InstanceProcessor().process(this, roundEnv);
        return true;
    }

}
