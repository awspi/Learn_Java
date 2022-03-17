package JavaSE.part3.Collection;

import java.util.*;

//通过保存键值对的形式来存储映射关系
public class Map {
    public static void main(String[] args) {
        test();
        test2();
        test3();
    }

    //LinkedHashMap
    public static void test(){

        //在遍历LinkedHashMap时，顺序就同我们的插入顺序一致。
        // 当然，也可以使用访问顺序，也就是说对于刚访问过的元素，会被排到最后一位。
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>(16, 0.75f, true);  //以访问顺序
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");
        map.get(2);
        System.out.println(map);
    }

    //TreeMap
    public static void test2(){
        TreeMap<Integer,String> map=new TreeMap<>((a,b)->a-b);
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");
        System.out.println(map);
    }

    //Map的使用
    public static void test3(){
        java.util.Map<Integer,String> map=new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");
        System.out.println(map.get(1));    //获取Key为1的值
        System.out.println(map.getOrDefault(0, "K"));  //不存在就返回K
        map.remove(1);   //移除这个Key的键值对

        //JDK1.8为我们提供了forEach方法使用：
        map.forEach((k,v)-> System.out.println(k+v));

        //也可以获取所有的Entry来foreach
        for (java.util.Map.Entry<Integer, String> entry : map.entrySet()) {   //也可以获取所有的Entry来foreach
            int key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key+" -> "+value);
        }

        System.out.println(map.keySet());   //直接获取所有的key
        System.out.println(map.values());   //直接获取所有的值
    }

    //集合的嵌套
    public static void test4(){
        java.util.Map<String, List<Integer>> map = new HashMap<>();   //每一个映射都是 字符串<->列表
        map.put("A", new LinkedList<>());
        map.put("B", new LinkedList<>());
        System.out.println(map.keySet());
        System.out.println(map.values());
        map.get("A").add(10);
        System.out.println(map.get("A").get(0));
    }
}
