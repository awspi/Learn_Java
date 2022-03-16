package JavaSE.Exp.exp3;

import java.util.Scanner;
//定义三个私有变量a，b，c；根据判别式j=bb-4a*c计算方程的解：若大于0，则有连个不同的实根，若是等于零则有两个相同的实根，若是小于零则无实根！
public class exp3_1 {
    public static void main(String[] args) {
        double x1,x2,x3;
        Scanner reader = new Scanner(System.in);
        System.out.println("请输入a,b,c的值：");
        x1=reader.nextDouble();
        x2=reader.nextDouble();
        x3=reader.nextDouble();
        exp3_1_Result R = new exp3_1_Result();
        R.setNumber(x1,x2,x3);
        R.judge();
    }
}