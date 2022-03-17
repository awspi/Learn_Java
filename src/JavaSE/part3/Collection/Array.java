package JavaSE.part3.Collection;

import java.util.*;

//Arrays是一个用于操作数组的工具类
public class Array {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }

    public static void test1() {
        int[] array = {1, 5, 2, 4, 7, 3, 6};
        Arrays.sort(array);   //Arrays.sort直接进行排序（底层原理：进行判断，元素少使用插入排序，大量元素使用双轴快速/归并排序）
        System.out.println(array);  //由于int[]是一个对象类型，而数组默认是没有重写toString()方法，因此无法打印到想要的结果
        //我们可以使用Arrays.toString()来像集合一样直接打印每一个元素出来
        System.out.println(Arrays.toString(array));

    }
    public static void test2(){
        int[] array = {1, 5, 2, 4, 7, 3, 6};
        Arrays.sort(array);
        System.out.println("排序后的结果："+Arrays.toString(array));
        System.out.println("目标元素3位置为："+Arrays.binarySearch(array, 3));  //二分搜素，必须是已经排序好的数组！
    }
    public static void test3(){
        int[] array = {1, 5, 2, 4, 7, 3, 6};
        Arrays
                .stream(array)    //将数组转换为流进行操作
                .sorted()
                .forEach(System.out::println);

    }
    public static void test4(){
        int[] array = {1, 5, 2, 4, 7, 3, 6};
        int[] array2 = Arrays.copyOf(array, array.length);  //copyOf复制一个一模一样的数组
        System.out.println(Arrays.toString(array2));

        System.out.println(Arrays.equals(array, array2));  //比较两个数组是否值相同

        Arrays.fill(array, 0);   //将数组的所有值全部填充为指定值
        System.out.println(Arrays.toString(array));

        Arrays.setAll(array2, i -> array2[i] + 2);  //依次计算每一个元素（注意i是下标位置）
        System.out.println(Arrays.toString(array2));   //这里计算让每个元素值+2
    }

    //多维数组
    public static void test5(){
        Integer[][] array = {{1, 5}, {2, 4}, {7, 3}, {6}};
        Integer[][] array2 = {{1, 5}, {2, 4}, {7, 3}, {6}};
        //不适配
        System.out.println(Arrays.toString(array));    //这样还会得到我们想要的结果吗？No
        System.out.println(Arrays.equals(array2, array));    //这样还会得到true吗？ false
        //deepToString deepEquals
        System.out.println(Arrays.deepToString(array));   //使用deepToString就能到打印多维数组
        System.out.println(Arrays.deepEquals(array2, array));   //使用deepEquals就能比较多维数组

    }
    //用`Arrays.asList()`来将数组转换为一个 **固定长度的List** 不能进行使长度改变的操作
    public static void test6(){
        Integer[] array = {1, 5, 2, 4, 7, 3, 6};
        List<Integer> list = Arrays.asList(array);   //不支持基本类型数组，必须是对象类型数组
        Arrays.asList("A", "B", "C");  //也可以逐个添加，因为是可变参数

        //list.add(1);    //此List实现是长度固定的，是Arrays内部单独实现的一个类型，因此不支持添加操作
        //list.remove(0);   //同理，也不支持移除

        list.set(0, 8);   //直接设置指定下标的值就可以
        list.sort(Comparator.reverseOrder());   //也可以执行排序操作
        System.out.println(list);   //也可以像List那样直接打印
    }
    public static void test7(){
        //`allows arrays to be viewed as lists`，实际上只是当做List使用，本质还是数组，因此数组的属性依然存在！
        // 因此如果要将数组快速转换为实际的List，可以像这样：
        Integer[] array = {1, 5, 2, 4, 7, 3, 6};
        List<Integer> list = new ArrayList<>(Arrays.asList(array));
    }
    //todo
    //Collocations类就是专用于集合的工具类


}

