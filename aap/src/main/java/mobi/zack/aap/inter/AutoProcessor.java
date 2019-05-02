package mobi.zack.aap.inter;

import mobi.zack.aap.AutoAnnotationProcessor;

import javax.annotation.processing.RoundEnvironment;

public interface AutoProcessor {
    public void processor(RoundEnvironment roundEnvironment, AutoAnnotationProcessor annotationProcessor);

}
