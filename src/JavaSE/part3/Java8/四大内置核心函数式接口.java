package JavaSE.part3.Java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class 四大内置核心函数式接口 {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }
    //消费型接口Consumer<T> 有参数，无返回值类型的接口。
    public static void test1(){
        consumo(500,x-> System.out.println(x));
    }
    public static void consumo(double money, Consumer<Double> c){
        c.accept(money);
    }


    //供给型接口，Supplier<T> 只有产出，没人输入，就是只有返回值，没有入参
    public static void test2(){
        Random ran=new Random();
        List<Integer> list = Supplier(10,()->ran.nextInt(10));
        System.out.println(list.toString());
    }
    public static List<Integer> Supplier(int sum, Supplier<Integer> sup){
        List<Integer> list=new ArrayList<Integer>();
            for(int i=0;i<sum;i++){
                list.add(sup.get());
            }
            return list;
    }


    //函数型接口：Function<R, T> 输入一个类型的参数，输出一个类型的参数，当然两种类型可以一致。
    public static void test3(){
        String s=strOperar("abcd",x->x.substring(0,2));
        System.out.println(s);
        String s2=strOperar("    abcd    ",x->x.trim());
        System.out.println(s2);
    }
    public static String strOperar(String str, Function<String,String>fun ){
        return fun.apply(str);
    }

    //断言型接口（boolean test（T t）） 输入一个参数，输出一个boolean类型得返回值。
    public static void test4(){
        List<Integer> l=new ArrayList<>();
        l.add(100);
        l.add(101);
        l.add(102);
        l.add(99);
        l.add(98);
        List<Integer>list=filterInt(l,x->(x>100));
    }
    //过滤集合
    public static List<Integer> filterInt(List<Integer> list, Predicate<Integer> pre){
        List<Integer> l=new ArrayList<>();
        for (Integer integer:list){
            if (pre.test(integer))l.add(integer);
        }
        return l;
    }

}
/*
* 除了上述得4种类型得接口外还有其他的一些接口供我们使用：

　　　　1）.BiFunction<T, U, R>

　　　　　　参数类型有2个，为T，U，返回值为R，其中方法为R apply(T t, U u)

　　　　2）.UnaryOperator<T>(Function子接口)

　　　　　　参数为T，对参数为T的对象进行一元操作，并返回T类型结果，其中方法为T apply(T t)

　　　　3）.BinaryOperator<T>(BiFunction子接口)

　　　　　　参数为T，对参数为T得对象进行二元操作，并返回T类型得结果，其中方法为T apply（T t1， T t2）

　　　　4）.BiConsumcr(T, U)

　　　　　　参数为T，U无返回值，其中方法为 void accept(T t, U u)

　　　　5）.ToIntFunction<T>、ToLongFunction<T>、ToDoubleFunction<T>

　　　　　　参数类型为T，返回值分别为int，long，double，分别计算int，long，double得函数。

　　　　6）.IntFunction<R>、LongFunction<R>、DoubleFunction<R>

　　　　　　参数分别为int，long，double，返回值为R。

　　以上就是java8内置得核心函数式接口，其中包括了大部分得方法类型，所以可以在使用得时候根据不同得使用场景去选择不同得接口使用。*/