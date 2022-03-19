package JavaSE.Exp.exp3;

public class exp3_1_Result {
    private double a;
    private double b;
    private double c;

    public void setNumber(double ... z) {//可变长参数，可以传入任意个该类型参数,简单来说就是个数组。
        a=z[0];
        b=z[1];
        c=z[2];
    }

    public void judge() {
        double j=b*b-4*a*c;
        double k=Math.sqrt(j);
        if(j<0) {
            System.out.println("方程无实根！");
        }
        else if(j==0) {
            System.out.println("方程只有一个实根："+(-1.0*b/2*a));
        }
        else if(j>0) {
            System.out.println("方程有两个不同的实根：");
            System.out.println((-1.0*b+k/2*a));
            System.out.println((-1.0*b-k/2*a));
        }
    }
}
