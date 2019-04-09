package lesson13.annotation;

import java.lang.annotation.*;
import java.lang.reflect.Method;

@Documented
@Target(ElementType.METHOD)
//TYPE
// METHOD
// FIELD -  к полю
//CONSTRUCTOR
// PARAMETER
@Retention(RetentionPolicy.RUNTIME)//время жизни аннотации
public @interface MethodInfo {
    String date();
    String author();
    int version() default  1;



}
