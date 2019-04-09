package lesson13.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)

public @interface FieldInfo {
    String date();
    String author();
    int version() default  1;


}
