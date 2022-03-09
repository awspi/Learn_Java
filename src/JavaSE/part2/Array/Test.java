package JavaSE.part2.Array;

import java.util.Arrays;

//数组可以代表任何相同类型的一组内容（包括引用类型和基本类型）其中存放的每一个数据称为数组的一个元素，数组的下标是从0开始
public class Test {
    public static void main(String[] args) {
        //创建
        int[] arr = new int[10];  //需要new关键字来创建！
        String[] arr2 = new String[10];
        //数组本身也是类（编程不可见，C++写的），不是基本数据类型！
        System.out.println(arr.length);   //数组有成员变量！
        System.out.println(Arrays.toString(arr));   //数组有成员方法
        arr[0]=999;
        System.out.println(arr[0]);
        test(arr);
        System.out.println(arr[0]);
    }
    static void test(int[] arr){//数组做实参，因为数组也是类，所以形参得到的是数组的引用而不是复制的数组，操作的依然是数组对象本身
        arr[0]=666;
    }
}
