package JavaSE.part2.OOP;

public class Main {
    public static void main(String[] args) {
//        func1();
//        func2();
//        test();
//        reload();
//        bulid();
        static_variable();
    }
    public  static void func1(){
        //传入方法的参数，如果是基本类型，会在调用方法的时候，对参数的值进行复制，方法中的参数变量，不是我们传入的变量本身！
        int a=1,b=2;
        Test test=new Test();
        test.swap(a,b); //相当于new Test().swap(a,b);
        System.out.println(a+"~"+b);
    }
    public  static void func2(){
        //传入方法的参数，如果是引用类型，那么传入的依然是该对象的引用！（类似于C语言的指针）
        Student stu0=new Student();
        stu0.name="psw";
        new Test().printName(stu0);
    }

    public static void test() {
        Student stu1=new Student();
        stu1.name="wsp";
        stu1.age=20;
        stu1.sport();
        stu1.speak("dnmd");
    }

    public static void reload () {
        new Test().r();
        new Test().r(2);
        new Test().r(1.1);
    }
    public static void bulid(){
        //构造方法（构造器）没有返回值
        //类要在一开始准备的所有东西，都会在构造方法里面执行，完成构造方法的内容后，才能创建出对象！
        Teacher tea1=new Teacher("bili");
        System.out.println(tea1.name);
        Teacher tea2=new Teacher();



    }

    public static void static_variable() {
        Teacher tea1=new Teacher("bili");
        Teacher tea2=new Teacher();
        //不推荐使用对象来调用，被标记为静态的内容，
        tea1.company="haut";
        System.out.println(tea2.company);
        //可以直接通过`类名.xxx`的形式访问
        Teacher.company="HAUT";
        System.out.println(tea1.company);
        System.out.println(Teacher.a);//0
    }
}
