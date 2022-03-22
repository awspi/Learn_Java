package JavaSE.part4;

import java.lang.reflect.Type;

public class Class_ {
    public static void main(String[] args) throws ClassNotFoundException {
        test1();
        test2();
        test3();
        test4();
    }

    public static void test1() throws ClassNotFoundException {
        Class<String> clazz = String.class;   //使用class关键字，通过类名获取
        Class<?> clazz2 = Class.forName("java.lang.String");   //使用Class类静态方法forName()，通过包名.类名获取，注意返回值是Class<?>
        Class<?> clazz3 = new String("ABC").getClass();  //通过实例对象获取

        System.out.println(clazz == clazz2);
        System.out.println(clazz == clazz3);
    }

    public static void test2() throws ClassNotFoundException {
        Class<String> clazz = String.class;   //使用class关键字，通过类名获取
        Class<?> clazz2 = Class.forName("java.lang.String");   //使用Class类静态方法forName()，通过包名.类名获取，注意返回值是Class<?>
        Class<?> clazz3 = new String("DEF").getClass();

        System.out.println(clazz == clazz2);
        System.out.println(clazz == clazz3);

        //

        Class<?> clazzz = int.class;   //基本数据类型有Class对象
        System.out.println(clazzz);

        System.out.println(Integer.TYPE == int.class);//包装类型都有一个TYPE，其实也就是基本类型的Class
        System.out.println(Integer.TYPE == Integer.class);//包装类型的Class对象并不是基本类型Class对象
    }

    public static void test3() {

        Class<String[]> clazz = String[].class;
        System.out.println(clazz.getName());  //获取类名称（得到的是包名+类名的完整名称）
        System.out.println(clazz.getSimpleName());
        System.out.println(clazz.getTypeName());
        System.out.println(clazz.getClassLoader());   //获取它的类加载器
//        System.out.println(clazz.cast(new Integer("10")));   //强制类型转换
    }

    //instance of
    public static void test4() {
        String str = "";
        System.out.println(str instanceof String);
        System.out.println(str.getClass() == String.class);   //直接判断是否为这个类型

        //需要判断是否为子类或是接口/抽象类的实现，我们可以使用`asSubClass()`方法：
        Integer i = 10;
        i.getClass().asSubclass(Number.class);   //当Integer不是Number的子类时，会产生异常

        //### 获取父类信息 通过`getSuperclass()`方法
        System.out.println(i.getClass().getSuperclass());
        //也可以通过`getGenericSuperclass()`获取父类的原始类型的Type
        Type type = i.getClass().getGenericSuperclass();
        System.out.println(type);
        System.out.println(type instanceof Class);


    }
}
