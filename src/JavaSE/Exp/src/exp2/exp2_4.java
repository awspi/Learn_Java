package exp2;

//编写一个Java应用程序，计算1-50之间的所有素数的和。
public class exp2_4 {
    public static void main(String[] args) {
        int sum = 0;
        System.out.print("1-50的素数为：");
        for (int i = 1; i <= 50; i++) {
            for (int j = 2; j <= i; j++) {
                if (i % j == 0) {
                    if (i == j) {
                        sum = sum + i;
                        System.out.print(i + " ");
                    } else
                        break;
                }
            }
        }
        System.out.println("\n和为：" + sum);
    }
}