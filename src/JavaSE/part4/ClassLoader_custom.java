package JavaSE.part4;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//自定义ClassLoader加载类 todo
public class ClassLoader_custom {
    //定义一个自己的ClassLoader
    static class MyClassLoader extends ClassLoader {
        public Class<?> defineClass(String name, byte[] b) {
            return defineClass(name, b, 0, b.length);   //调用protected方法，支持载入外部class文件
        }
    }

    public static void main(String[] args) throws IOException {
        MyClassLoader classLoader = new MyClassLoader();
        FileInputStream stream = new FileInputStream("test.class");
        byte[] bytes = new byte[stream.available()];
        stream.read(bytes);
        Class<?> clazz = classLoader.defineClass("com.test", bytes);   //类名必须和我们定义的保持一致
        System.out.println(clazz.getName());   //成功加载外部class文件
        //可以对此类进行操作了（注意，我们无法在代码中直接使用此类型，因为它是我们直接加载的）

        //创建一个此类的对象并调用其方法：
        try {
            Object obj = clazz.newInstance();
            Method method = clazz.getMethod("test", String.class);   //获取我们定义的test(String str)方法
            method.invoke(obj, "哥们这瓜多少钱一斤？");
        }catch (Exception e){
            e.printStackTrace();
        }
        //修改成员字段之后，再来调用此方法：
        try {
            Object obj = clazz.newInstance();
            Field field = clazz.getField("text");   //获取成员变量 String text;
            field.set(obj, "华强");
            Method method = clazz.getMethod("test", String.class);   //获取我们定义的test(String str)方法
            method.invoke(obj, "哥们这瓜多少钱一斤？");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
