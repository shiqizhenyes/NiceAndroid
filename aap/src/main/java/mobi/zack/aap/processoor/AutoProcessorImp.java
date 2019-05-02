package mobi.zack.aap.processoor;

import mobi.zack.aap.AutoAnnotationProcessor;
import mobi.zack.aap.annotation.AutoProcessorFactory;
import mobi.zack.aap.inter.AutoProcessor;

import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.ElementFilter;
import javax.tools.FileObject;
import javax.tools.StandardLocation;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Set;

public class AutoProcessorImp implements AutoProcessor {

    @Override
    public void processor(RoundEnvironment roundEnvironment, AutoAnnotationProcessor annotationProcessor) {
        Set<TypeElement> elementSet = ElementFilter
                .typesIn(roundEnvironment.getElementsAnnotatedWith(AutoProcessorFactory.class));
        String filePath = "META-INF/services/";
        String fileName = "javax.annotation.processing.Processor";
        for (TypeElement e: elementSet) {
            try {
                FileObject fileObject = annotationProcessor
                        .getFiler()
                        .createResource(StandardLocation.CLASS_OUTPUT, "", filePath + fileName);
                OutputStream fileOutputStream = fileObject.openOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8));
                writer.write(e.getQualifiedName().toString());
                writer.flush();
                writer.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }
    }

}
