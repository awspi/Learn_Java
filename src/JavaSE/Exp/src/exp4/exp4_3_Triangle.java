package exp4;

public class exp4_3_Triangle extends exp4_3_Shape {
    private double a,b,c;
    public exp4_3_Triangle(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    @Override
    public double area() {//海伦公式求面积
        double p=(a+b+c)/2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }

    @Override
    public double perimeter() {
        return a+b+c;
    }


}
