package JavaSE.Exp.exp3;

public class exp3_5_Circle extends exp3_5_Shape {
    private double a;
    public exp3_5_Circle(double a){
       this.a = a;
    }
    public void getArea() {
        double c = 3.14*a*a;
        System.out.println("圆形的面积为："+c);
    }
    public void getPerimeter() {
        double c = 3.14*a*2;
        System.out.println("圆形的周长为："+c);
    }
}
