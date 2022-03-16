package JavaSE.Exp.exp3;

public class exp3_6 {
    public static void main(String[] args) {
        Circle2D c1 = new Circle2D(1,1,6);
        Circle2D c2 = new Circle2D(4, 5, 10.5);
        System.out.println(c1);
        System.out.println("c1面积:"+c1.getArea()+"\n周长:"+c1.getPerimeter());
        System.out.println(c2);
        System.out.println("c2面积:"+c2.getArea()+"\n周长:"+c2.getPerimeter());
        System.out.println("是否在圆内 :"+c1.contains(3, 3));
        System.out.println("是否在圆内:"+c1.contains(c2));
        System.out.println("是否重叠:"+c1.overlaps(c2));

    }
}
class Circle2D{
    double x;
    double y;
    double radius;


    public Circle2D() {
        this.x = 1;
        this.y = 1;
        this.radius = 1;
    }

    public Circle2D(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    public  double getArea(){
        return Math.PI * getRadius() * getRadius();
    }
    public  double getPerimeter(){
        return  2 * Math.PI * getRadius();
    }

    public boolean contains(double x,double y){
        if((x-this.x) *(x-this.x) + (y-this.y)*(y-this.y) <= radius * radius)
            return  true;
        return false;
    }
    public boolean contains(Circle2D circle){
        double s =  (circle.getY() - this.getY())*(circle.getY() - this.getY())
                + (circle.getX() - this.getX()) *(circle.getX() - this.getX());
        s = Math.sqrt(s);
        if(s <= this.getRadius() -circle.getRadius())
            return true;
        return false;
    }
    public boolean overlaps(Circle2D circle){
        double s =  (circle.getY() - this.getY())*(circle.getY() - this.getY())
                + (circle.getX() - this.getX()) *(circle.getX() - this.getX());
        s = Math.sqrt(s);
        if(s <= this.getRadius() + circle.getRadius() && s >= this.getRadius() -circle.getRadius())
            return true;
        return false;
    }
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return "Circle2D{" +
                "x=" + x +
                ", y=" + y +
                ", radius=" + radius +
                '}';
    }
}