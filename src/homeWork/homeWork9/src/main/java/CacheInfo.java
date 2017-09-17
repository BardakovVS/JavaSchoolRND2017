package homeWork.homeWork9.src.main.java;//package main.java;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface CacheInfo {


    Enums cacheType() default Enums.FILE;
    String fileName() default "сache.dat";
    boolean zip() default true;
    Class[] identityBy() default {String.class, Double.class};
    int listList() default 100;


}