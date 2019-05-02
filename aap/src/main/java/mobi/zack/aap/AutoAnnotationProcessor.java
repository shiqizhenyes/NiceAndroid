package mobi.zack.aap;

import mobi.zack.aap.processoor.AutoProcessorImp;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import java.util.Set;

@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedAnnotationTypes({"mobi.zack.aap.annotation.AutoProcessorFactory"})
public class AutoAnnotationProcessor extends AbstractProcessor {

    public Filer filer;
    private Elements elements;
    private Messager messager;

    public Filer getFiler() {
        return filer;
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        filer = processingEnv.getFiler();
        elements = processingEnv.getElementUtils();
        new AutoProcessorImp().processor(roundEnv, this);
        return true;
    }
}
