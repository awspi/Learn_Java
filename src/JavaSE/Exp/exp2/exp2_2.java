package JavaSE.Exp.exp2;
//编写一个Java应用程序，输出全部的希腊字母。
public class exp2_2 {
    public static void main(String[] args) {
        char a = 'α',b = 'ω';
        System.out.print("全部的希腊字母为：");
        for(int i = (int)a; i < (int)b + 1; i++){
            System.out.print((char)i+"  ");
        }
    }
}
