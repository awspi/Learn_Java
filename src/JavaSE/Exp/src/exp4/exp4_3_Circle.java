package exp4;

public class exp4_3_Circle extends exp4_3_Shape {
    private double radius;
    public exp4_3_Circle(double radius){
        this.radius = radius;
    }
    @Override
    public double area() {
        return Math.PI*radius*radius;
    }

    @Override
    public double perimeter() {
        return 2*Math.PI*radius;
    }
}
