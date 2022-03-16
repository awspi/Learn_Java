package JavaSE.Exp.exp1;

import java.util.Scanner;

public class exp1_4 {
    public static void main(String[] args) {
        System.out.println("请输入数组元素的个数：");
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int[] arr= new int[n];
        int sum=0;
        System.out.println("请输入元素：");
        for(int i=0;i<arr.length;i++){
            arr[i]=reader.nextInt();
            sum=sum+arr[i]; //求和
        }
        double aver = sum*1.0/arr.length; //求平均值
        System.out.println("平均值为："+aver);
        System.out.println("和为："+sum);

    }
}