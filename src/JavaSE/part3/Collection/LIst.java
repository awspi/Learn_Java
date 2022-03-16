package JavaSE.part3.Collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LIst {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
//向列表中添加元素
        list.add("A");
        list.add("B");
        list.add("A");
        list.add("B");
        System.out.println(list.contains("C")); //是否包含某个元素
        System.out.println(list);
//移除元素：
        list.remove(0);   //按下标移除元素Removes the first occurrence
        list.remove("B");    //移除指定元素
        System.out.println(list);
//批量操作：
        ArrayList<String> list0 = new ArrayList<>();
        list0.addAll(new ArrayList<>());   //在尾部批量添加元素
        list0.removeAll(new ArrayList<>());   //批量移除元素（只有给定集合中存在的元素才会被移除）
        list0.retainAll(new ArrayList<>());   //只保留某些元素
        System.out.println(list0);

        //利用代码块来快速添加内容
        List<Integer> list2=new LinkedList<Integer>(){
            {
            this.add(1);
            this.add(3);
            this.add(2);
            this.add(4);
            }
        };
        System.out.println(list2);
        //集合的排序 lambda表达式
        list2.sort((a,b)->{return a-b;});//返回值小于0，表示a应该在b前面，返回值大于0，表示b应该在a后面，等于0则不交换
        System.out.println(list2);
    }

//    LinkedList本质就是一个双向链表,现了Queue接口，所以LinkedList也能被当做一个队列或是栈来使用。
    public static void test(){
        LinkedList<String> list = new LinkedList<>();
        list.offer("A");   //入队
        System.out.println(list.poll());  //出队
        list.push("A");
        list.push("B");    //进栈
        list.push("C");
        System.out.println(list.pop());
        System.out.println(list.pop());    //出栈
        System.out.println(list.pop());
    }

}
