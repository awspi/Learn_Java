package JavaSE.part3.Collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Iterable {
    public static void main(String[] args) {
        test();
        List<Integer> list = new LinkedList<Integer>(){   //Java9才支持匿名内部类使用钻石运算符
            {
                this.add(10);
                this.add(2);
                this.add(5);
                this.add(8);
            }
        };
        Iterator<Integer> iterator = list.iterator();   //生成一个新的迭代器
        while (iterator.hasNext()){    //判断是否还有下一个元素
            Integer i = iterator.next();     //获取下一个元素（获取一个少一个）
            System.out.println(i);
        }
    }
    public static void test(){//遍历
        List<Integer> list = new LinkedList<Integer>(){   //Java9才支持匿名内部类使用钻石运算符
            {
                this.add(10);
                this.add(2);
                this.add(5);
                this.add(8);
            }
        };
        //所有的集合类，都支持foreach循环
        for (Integer integer : list) {
            System.out.println(integer);
        }
        //forEach
        list.forEach(i -> {
            System.out.println(i);
        });
        //lambda表达式
        list.forEach(System.out::println);
        list.replaceAll((i) -> {
            if(i == 2) return 3;   //将所有的2替换为3
            else return i;   //不是2就不变
        });
        System.out.println(list);

    }

}
