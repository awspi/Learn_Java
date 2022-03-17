package JavaSE.part3.Java8;
//https://www.cnblogs.com/wuyx/p/8972249.html
import java.util.Comparator;
import java.util.function.Consumer;

public class Lambda {
    public static void main(String[] args) {
        test();
        test2();
        test3();
        test4();
        test5();
    }
    public static void test(){
        //语法一：无参数，无返回值（（）-> 执行的代码）
        Runnable run =()-> System.out.println("Hello Lambda");
        run.run();
        //old
        Runnable run1=new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World");
            }
        };
        run1.run();

    }
    //语法二：一个参数，无返回值
    public static void test2(){
        //如果只有一个参数，小括号可以不写。
        Consumer<String> t=x-> System.out.println(x);
        t.accept("Hello Lambda");
    }
    //语法三：多个参数，多条语句，有返回值。
    public static void test3(){
        Comparator<Integer> com=(x, y)->{
            System.out.println(x);
            System.out.println(y);
            return 0;
        };
        System.out.println(com.compare(1,3));
    }
    //语法四：多个参数，一条语句，有返回值
    public static void test4(){
        //只有一条语句与返回值时，大括号和return都可以省略
        Comparator<Integer> com =(x,y)->0;
        System.out.println(com.compare(1,2));
    }
    public static int myTest(int o1, int o2, myLambdaModle<Integer> m){
        return m.test(o1,o2);
    }
    public static void test5(){
        //使用一个接口就对数字进行运算操作，具体什么操作可以自己去定义。
        int sum1=myTest(3,6,(x,y)->x*y);
        System.out.println(sum1);
        int sum2=myTest(3,6,(x,y)->x+y);
        System.out.println(sum2);
    }
}
