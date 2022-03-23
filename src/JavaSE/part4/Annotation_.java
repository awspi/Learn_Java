package JavaSE.part4;
//注解

import java.lang.annotation.Annotation;

public class Annotation_ {
    //注解本质上也是一个类，只不过它的用法比较特殊。
    //注解可以被标注在任意地方，包括方法上、类名上、参数上、成员属性上、注解定义上等，就像注释一样，它相当于我们对某样东西的一个标记。
    //而与注释不同的是，注解可以通过反射在运行时获取，注解也可以选择是否保留到运行时。
    //预设注解：
    //元注解：



    @Test(value = "ABC", test = {"HAHA"})//`@Target`限定为只能作用于方法上
    public static void test1(){
    }
    @Test(value = "!",test = "aaa")//当属性为数组，我们在使用注解传参时，如果数组里面只有一个内容，我们可以直接传入一个值，而不是创建一个数组：
    public static void test2(){
    }

    //反射获取注解
    public static void main(String[] args) throws NoSuchMethodException {
        Class<Student> clazz = Student.class;
        for (Annotation annotation : clazz.getAnnotations()) { //无论是方法、类、还是字段，都可以使用`getAnnotations()`方法（还有几个同名的）来快速获取我们标记的注解。
            System.out.println(annotation.annotationType());   //获取类型
            System.out.println(annotation instanceof Test2);   //直接判断是否为Test
            Test2 test = (Test2) annotation;
            System.out.println(test.value());   //获取我们在注解中写入的内容
        }
        //通过反射机制，我们可以快速获取到我们标记的注解，同时还能获取到注解中填入的值，
        for (Annotation annotation : clazz.getMethod("test").getAnnotations()) {
            System.out.println(annotation.annotationType());   //获取类型
            System.out.println(annotation instanceof Test);   //直接判断是否为Test
            Test test = (Test) annotation;
            System.out.println(test.value());   //获取我们在注解中写入的内容
        }



    }
    @Test2("我是类上的注释")
    public class Student{
        public void test(){
            System.out.println("方法被调用");
        }
    }
}
