package JavaSE.Exp.exp2;
//一个数如果恰好等于它的因子之和，这个数就称为“完数”。编写应用程序求1000之内的所有完数
public class exp2_6 {
    public static void main(String[] args) {
        int i, j;
        System.out.print("1000之内的完数：\n");
        for(i = 1; i <= 1000; i++){
            int sum = 0;
            for(j = 1; j < i; j++){
                if(i % j == 0)
                    sum += j;
            }
            if(i == sum)
                System.out.print(i+" ");
        }
    }
}
