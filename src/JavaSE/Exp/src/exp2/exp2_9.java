package JavaSE.Exp.exp2;
//编写一个Java应用程序，产生20个50-100之内的整数，并输出这20个数并找出最大数及最小数输出。

import java.util.Arrays;
import java.util.Random;

public class exp2_9 {
    public static void main(String[] args) {
        int[] arr = new int[20];
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(50) + 50;//50到100之间的随机数 nextInt(n)，随机产生[0,n]内的整数
        }
        System.out.println("随机数：" + Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));
        System.out.println("最大值：" + arr[0]);
        System.out.println("最小值：" + arr[arr.length - 1]);
    }
}
