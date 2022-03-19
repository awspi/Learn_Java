package JavaSE.Exp.exp1;

import java.util.Scanner;

public class exp1_3 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("输入数字：");
        int a=input.nextInt();
        int sum = 0;
        while(a / 10 != 0){
            sum += a % 10;
            a=a/10;
        }
        sum = sum + a;
        System.out.println("各位数字之和为："+sum);
    }

}
