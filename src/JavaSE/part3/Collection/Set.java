package JavaSE.part3.Collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

//特点：
//不允许出现重复元素
//不支持随机访问（不允许通过下标访问）
public class Set {
    public static void main(String[] args) {
        HashSet<Integer> set=new HashSet<>();
        set.add(11);//支持插入元素，但是不支持指定位置插入
        set.add(22);
        set.add(33);
        for (Integer integer :set){
            System.out.println(integer);
        }
        //后Set集合中存在的元素顺序，并不是我们的插入顺序，




        //这是因为HashSet底层是采用哈希表来实现的，实际的存放顺序是由Hash算法决定的
//那么我们希望数据按照我们插入的顺序进行保存该怎么办呢？我们可以使用LinkedHashSet：
        LinkedHashSet<Integer> set2 = new LinkedHashSet<>();  //会自动保存我们的插入顺序
        set2.add(120);
        set2.add(13);
        set2.add(11);
        for (Integer integer : set2) {
            System.out.println(integer);
        }
        //LinkedHashSet底层维护的不再是一个HashMap，而是LinkedHashMap，
        // 能够在插入数据时利用链表自动维护顺序，保证我们插入顺序和最后的迭代顺序一致



        //TreeSet，它会在元素插入时进行排序 默认数字的小->大进行排列
        TreeSet<Integer> set3 = new TreeSet<>((a, b) -> b - a);//在创建对象时指定规则从大到小
        set3.add(1);
        set3.add(3);
        set3.add(2);
        System.out.println(set3);
    }
}
