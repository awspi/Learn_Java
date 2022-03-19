package exp4;

public class exp4_3_Rectangle extends exp4_3_Shape {
    private double width;
    private double height;
    public exp4_3_Rectangle(double width, double height){
        this.width = width;
        this.height = height;
    }
    @Override
    public double area() {
        return width*height;
    }

    @Override
    public double perimeter() {
        return 2*(width+height);
    }
}
