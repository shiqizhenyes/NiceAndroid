package me.nice.apt.inter;

import java.util.Set;

import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.TypeElement;

import me.nice.apt.AnnotationProcessor;

public interface IProcessor {

    void process(AnnotationProcessor annotationProcessor, RoundEnvironment roundEnv);

}
