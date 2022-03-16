package JavaSE.Exp.exp2;
//编写一个Java应用程序，计算1！+2！+3！+…+10！。
public class exp2_3 {
    public static void main(String[] args) {
        int sum=1;
        int num=1;
        for(int i=2;i<11;i++){
            num*=i;
            sum+=num;
        }
        System.out.println("1！+2！+3！+…+10！="+sum);
    }
}
