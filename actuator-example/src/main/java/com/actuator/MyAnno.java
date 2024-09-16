package com.actuator;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
 @interface MyAnno {


     int myValue() default 0;

     String name() default "Ashoka";

     String city() default "Pune";

}
