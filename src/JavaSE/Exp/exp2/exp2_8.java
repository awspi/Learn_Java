package JavaSE.Exp.exp2;
//编写一个Java应用程序，产生10个100之内的随机整数输出，并把这10个数从小到大的顺序输出。
import java.util.Arrays;
import java.util.Random;

public class exp2_8 {
    public static void main(String[] args) {
        int[] a=new int[10];
        Random r = new Random();
        for(int i = 0; i < a.length; i++) {
            a[i] = r.nextInt(91) + 10;//10到100之间的随机数，包含100 nextInt(n)，随机产生[0,n]内的整数
        }

        System.out.println("随机数："+Arrays.toString(a));
        Arrays.sort(a);
        System.out.println("排序后："+Arrays.toString(a));
    }
}
