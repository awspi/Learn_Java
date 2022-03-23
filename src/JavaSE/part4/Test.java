package JavaSE.part4;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})//`@Target`限定为只能作用于方法上
@Retention(RetentionPolicy.RUNTIME)
public @interface Test {
    //默认只有一个属性时，我们可以将其名字设定为value，否则，我们需要在使用时手动指定注解的属性名称，使用value则无需填入：
    String value();
    //注解的成员变量在注解的定义中以“无形参的方法”形式来声明，其方法名定义了该成员变量的名字，其返回值定义了该成员变量的类型：
    String[] test()default "默认值，会转化为数组";//注解的属性也叫做成员变量



}