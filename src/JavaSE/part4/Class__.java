package JavaSE.part4;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

//通过Class对象来创建对象、调用方法、修改变量
public class Class__ {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
    test1();
    test2();
    }

    public static void test1() throws InstantiationException, IllegalAccessException {
        //通过使用`newInstance()`方法来创建对应类型的实例，返回泛型T
        //InstantiationException（有参构造）和IllegalAccessException异常（调用private方法）
        Class<Student> clazz = Student.class;
//        Student student = clazz.newInstance(); //只支持无参构造
//        student.test();
    };
    public static void test2() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //通过获取类的构造方法（构造器）来创建对象实例，会更加合理，
        // 我们可以使用`getConstructor()`方法来获取类的构造方法，同时我们需要向其中填入参数，也就是构造方法需要的类型
        Class<Student> clazz=Student.class;
//        clazz.getConstructor(String.class).newInstance("AAA");

        //当访问权限不足时，会无法找到此构造方法，使用 getDeclaredConstructor()找到非public的构造方法
        Constructor<Student> constructor=clazz.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);//修改访问权限
        Student student=constructor.newInstance("wsp");
        student.test();
        //使用`getDeclaredConstructor()`方法可以找到类中的非public构造方法，
        // 但是在使用之前，我们需要先修改访问权限，
        // 在修改访问权限之后，就可以使用非public方法了
        // （这意味着，反射可以无视权限修饰符访问类的内容）


    };
    static class Student{
        private Student(String str){}
        public void test(){
            System.out.println("萨日朗");
        }
    }
}
