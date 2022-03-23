package JavaSE.part4;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//通过反射机制，可以快速获取到我们标记的注解，同时还能获取到注解中填入的值
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Test2 {
    String value() default "默认";
}
