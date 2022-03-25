package exp5;

import java.util.Scanner;
public class exp5_1 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            while (true) {
                try {
                    System.out.println("输入除数");
                    double d1 = Double.parseDouble(sc.nextLine());
                    System.out.println("输入被除数");
                    double d2 = Double.parseDouble(sc.nextLine());
                    if (d2 == 0) {
                        throw new ArithmeticException("手动抛出除零异常 ArithmeticException");//手动抛出除零异常
                    }
                    double d3 = d1 / d2;
                    System.out.println("计算结果：" + d1 + "/" + d2 + "=" + d3);
                    break;
                } catch (NumberFormatException e1) {//捕获数字格式异常
                    System.out.println("捕获到数字格式异常 NumberFormatException");
                    continue;
                } catch (ArithmeticException e2) {//捕获到除零异常
                    System.out.println(e2.getMessage());
                    continue;
                }
            }
        }
}
