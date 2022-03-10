package JavaSE.part2.Array;

import java.util.Arrays;

//数组可以代表任何相同类型的一组内容（包括引用类型和基本类型）其中存放的每一个数据称为数组的一个元素，数组的下标是从0开始
public class Test {
    public static void main(String[] args) {
    create();
    circle();
    create2();
    varargs("test",1,2,3,4);
    }
    static void create(){
        //创建
            /*类型[] 变量名称 = new 类型[数组大小];
            类型 变量名称n = new 类型[数组大小];  //支持C语言样式，但不推荐！
            类型[] 变量名称 = new 类型[]{...};  //静态初始化（直接指定值和大小）
            类型[] 变量名称 = {...};   //同上，但是只能在定义时赋值*/

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
    static  void circle(){
        int[] arr = new int[]{3,3,8,0,2,6};
        for (int i:arr){//foreach属于增强型的for循环，能直接拿到数组中的每一个数字。
            System.out.println(i);
        }
    }
    static void create2(){//二维数组
        int[][] arr=new int[][]{
                {1,2},
                {3,4},
                {5,6}
        };

        System.out.println("way1:");
        for (int i=0;i<3;i++){
            for (int j=0;j<2;j++){
                System.out.println(arr[i][j]);
            }

        System.out.println("way2:");
            for (int[] ar:arr){//foreach
                for (int a:ar){
                    System.out.println(a);
                }
            }
        }

    }
    static void varargs(String str,int... arr){//...可变长参数
        //可变长参数其实就是数组的一种应用我们可以指定方法的形参为一个可变长参数，要求实参可以根据情况动态填入0个或多个，而不是固定的数量
//        由于是数组，所以说只能使用一种类型的可变长参数，并且可变长参数只能放在最后一位！
        for (int ar:arr) System.out.println(ar);
        System.out.println(arr[2]);
    }
}
