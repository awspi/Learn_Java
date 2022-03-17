package JavaSE.part3.Collection;

import java.util.*;
import java.util.stream.Collectors;

public class Stream {
    public static void main(String[] args) {
        test();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
    }

    //Stream操作
    public static void test(){
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        //移除为B的元素
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            if(iterator.next().equals("A")) iterator.remove();
        }

        //Stream操作
        list = list     //链式调用
                .stream()    //获取流
                .filter(e -> !e.equals("B"))   //只允许所有不是B的元素通过流水线
                .collect(Collectors.toList());   //将流水线中的元素重新收集起来，变回List
        System.out.println(list);
    }


    //当遇到大量的复杂操作时，我们就可以使用Stream来快速编写代码
    public static void test2(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list=list.stream()
                .distinct() //去重
                .sorted((a,b)->a-b)//进行倒序排列
                .map(e->e+1)//每个元素都要执行+1操作
                .limit(2)//只放行前两个元素
                .collect(Collectors.toList());
        System.out.println(list);


        //不能认为每一步是直接依次执行的！
        //实际上，stream会先记录每一步操作，而不是直接开始执行内容，
        // 当整个链式调用完成后，才会依次进行！
    }

//更多流操作
    public static void test3(){
        Random random = new Random();  //Random是一个随机数工具类
        random
                .ints(-100, 100)   //生成-100~100之间的，随机int型数字（本质上是一个IntStream）
                .limit(10)   //只获取前10个数字（这是一个无限制的流，如果不加以限制，将会无限进行下去！）
                .filter(i -> i < 0)   //只保留小于0的数字
                .sorted()    //默认从小到大排序
                .forEach(System.out::println);   //依次打印
    }


    //统计实例来帮助我们快速进行统计
    public static void test4(){
        Random random = new Random();  //Random是一个随机数工具类
        IntSummaryStatistics statistics = random
                .ints(0, 100)
                .limit(100)
                .summaryStatistics();    //获取语法统计实例
        System.out.println(statistics.getMax());  //快速获取最大值
        System.out.println(statistics.getCount());  //获取数量
        System.out.println(statistics.getAverage());   //获取平均值
    }
//    转换到IntStream
    public static void test5(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.stream()
                .mapToInt(i -> i)    //将每一个元素映射为Integer类型（这里因为本来就是Integer）
                .summaryStatistics();
    }

    //通过`flat`来对整个流进行进一步细分
    public static void test6(){
        List<String> list = new ArrayList<>();
        list.add("A,B");
        list.add("C,D");
        list.add("E,F");   //我们想让每一个元素通过,进行分割，变成独立的6个元素
        list = list
                .stream()    //生成流
                .flatMap(e -> Arrays.stream(e.split(",")))    //分割字符串并生成新的流
                .collect(Collectors.toList());   //汇成新的List
        System.out.println(list);   //得到结果
    }


    //reduce方法
    public static void test7(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        int sum = list
                .stream()
                .reduce((a, b) -> a + b)   //计算规则为：a是上一次计算的值，b是当前要计算的参数，这里是求和
                .get();    //我们发现得到的是一个Optional类实例，不是我们返回的类型，通过get方法返回得到的值
        System.out.println(sum);
    }

    //Optional类是Java8为了解决null值判断问题，使用Optional类可以避免显式的null值判断
    public static void test8(){
        List<String> list = new ArrayList<>();
        String str = null;

        if(str != null){   //当str不为空时添加元素到List中
            list.add(str);
        }
        //Optional
        Optional<String> optional = Optional.ofNullable(str);   //转换为Optional
        optional.ifPresent(System.out::println);  //当存在时再执行方法
        System.out.println(optional.orElse("Dnmd"));//当值为null时，获取备选值
        // System.out.println(optional.get());   这样会直接报错


        String str1 = "A";
        Optional optional1 = Optional.ofNullable(str1);   //转换为Optional（可空）
        System.out.println(optional1.filter(s->s.equals("A")).map(s -> s + "A").get());



    }
}
