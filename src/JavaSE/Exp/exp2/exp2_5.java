package JavaSE.Exp.exp2;
//分别用do-while和for循环计算1+1/2!+1/3!+1/4!…  … 的前20项和
public class exp2_5 {
    public static void main(String[] args) {
        double sum=0,item=1;
        int i=1;

        for(;i<=20;) {//for循环计算
            sum = sum+item;
            i=i+1;
            item = item*(1.0/i);
        }

        do {//do-while循环计算
            sum = sum+item;
            i=i+1;
            item = item*(1.0/i);
        }while(i<=20);
        System.out.println("1+1/2!+1/3!+1/4!… 前20项和="+sum);

    }
}
