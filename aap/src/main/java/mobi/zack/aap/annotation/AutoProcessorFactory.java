package mobi.zack.aap.annotation;

import mobi.zack.aap.AutoAnnotationProcessor;

import javax.annotation.processing.RoundEnvironment;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface AutoProcessorFactory {
    Class<?>[] value();
}
