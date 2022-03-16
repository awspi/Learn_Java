package JavaSE.Exp.exp3;

public class exp3_5_rectangle extends exp3_5_Shape{
    private int a,b;
    public exp3_5_rectangle(int a, int b){
        this.a = a;
        this.b = b;
    }
    public void getArea() {
        int c = a*b;
        System.out.println("长方形的面积为："+c);
    }
    public void getPerimeter() {
        int d = (a+b)*2;
        System.out.println("长方形的周长为："+d);
    }
}
