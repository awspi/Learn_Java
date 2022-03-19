package JavaSE.Exp.exp3;

public class exp3_5_Triangle extends exp3_5_Shape{
    private int a,b;
    public exp3_5_Triangle(int a, int b){
        this.a = a;
        this.b = b;
    }
    public void getArea() {
        int c = a*b/2;
        System.out.println("三角形的面积为："+c);
    }
}
