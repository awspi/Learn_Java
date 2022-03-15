package JavaSE.part3.Collection;

import java.util.ArrayList;
import java.util.List;

public class Main   {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("A");
        list.add("B");
        System.out.println(list.contains("C")); //是否包含某个元素
        System.out.println(list);
        list.remove(0);   //按下标移除元素Removes the first occurrence
        list.remove("B");    //移除指定元素
        System.out.println(list);

    }
}
