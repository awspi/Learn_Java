package JavaSE.part4;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class Reflection_ {
    public static void main(String[] args) throws ReflectiveOperationException {
        test1();
        test2();
        test3();
//        test4();
//        test5();
    }

    //调用类的方法
    public static void test1() throws ReflectiveOperationException {
        Class<?> clazz = Class.forName("JavaSE.part4.student_");
        //通配符，返回的不是student_类 只能是object
        Object instance = clazz.newInstance();//创建学生对象
        Method method = clazz.getMethod("test", String.class);//通过方法名和形参类型获取类中的方法
        method.invoke(instance, "wsp"); //通过Method对象的invoke方法来调用方法
        //同构造方法一样，当出现非public方法时，我们可以通过反射来无视权限修饰符，获取非public方法并调用
        //
        // Method method = clazz.getDeclaredMethod("test", String.class);   //通过方法名和形参类型获取类中的方法 可变参数 可以直接使用数组的class对象表示：String[].class
        // method.setAccessible(true);
        //  method.invoke(instance, "what's up");   //通过Method对象的invoke方法来调用方法

        //通过调用`getMethod()`方法，我们可以获取到类中所有声明为public的方法，得到一个Method对象，
        // 我们可以通过Method对象的`invoke()`方法（返回值就是方法的返回值，因为这里是void，返回值为null）来调用已经获取到的方法，注意传参

        //我们发现，利用反射之后，在一个对象从构造到方法调用，没有任何一处需要引用到对象的实际类型，我们也没有导入Student类，
        // 整个过程都是反射在代替进行操作，使得整个过程被模糊了，过多的使用反射，会极大地降低后期维护性。

        //Method和Constructor都和Class一样，他们存储了方法的信息，包括方法的形式参数列表，返回值，方法的名称等内容，我们可以直接通过Method对象来获取这些信息：
        System.out.println(method.getName());//获取方法名称
        System.out.println(method.getReturnType()); //获取返回值类型
    }

    //修改类的属性
    public static void test2() throws ReflectiveOperationException {//可以通过反射访问一个类中定义的成员字段也可以修改一个类的对象中的成员字段值
        Class<?> clazz = Class.forName("JavaSE.part4.student_");
        Object instance = clazz.newInstance();

        Field field = clazz.getField("i"); //通过`getField()`方法来获取一个类定义的指定字段
        field.set(instance, 100);   //直接通过`set()`方法为某个对象，设定此属性的值
        // 将类实例instance的成员字段i设置为100

        Method method = clazz.getMethod("test", String.class);
        method.invoke(instance, "tired");

        //在得到Field之后，我们就可以直接通过`set()`方法为某个对象，设定此属性的值，比如上面，我们就为instance对象设定值为100，
        // 当访问private字段时，同样可以按照上面的操作进行越权访问：
        // Field field = clazz.getDeclaredField("i");   //getDeclaredField
        //field.setAccessible(true);
    }

    //反射几乎可以把一个类的老底都给扒出来，任何属性，任何内容，都可以被反射修改，无论权限修饰符是什么，
    // 那么，如果我的字段被标记为final呢？现在在字段`i1`前面添加`final`关键字，
    public static void test3() throws ReflectiveOperationException {
        Class<?> clazz = Class.forName("JavaSE.part4.student_");
        Object instance = clazz.newInstance();
        Field field = clazz.getDeclaredField("i1");
        field.setAccessible(true);
        field.set(instance, 1200);
        Method method = clazz.getMethod("test", String.class);
        method.invoke(instance, "final");//当字段为final时，不会报错但是不能修改
    }



    //todo 测试发现test4 5都报错，可能是在jdk15，演示是在jdk1.8 待验证
    public static void test4() throws ReflectiveOperationException {

//        通过反射可以直接将final修饰符直接去除
        Integer i = 10;

        Field field = Integer.class.getDeclaredField("value");

        Field modifiersField = Field.class.getDeclaredField("modifiers");  //这里要获取Field类的modifiers字段进行修改
        //Exception in thread "main" java.lang.NoSuchFieldException: modifiers
        modifiersField.setAccessible(true);
        modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);  //去除final标记

        field.setAccessible(true);
        field.set(i, 100);   //强行设置值

        System.out.println(i);
        //反射非常暴力，就连被定义为final字段的值都能强行修改，几乎能够无视一切阻拦
    }

    //try修改一些其他的类型
    public static void test5() throws ReflectiveOperationException {
        List<String> i = new ArrayList<>();

        Field field = ArrayList.class.getDeclaredField("size");
        field.setAccessible(true);
        field.set(i, 10);

        i.add("测试");   //只添加一个元素
        System.out.println(i.size());  //大小直接变成11
        i.remove(10);

    }
}