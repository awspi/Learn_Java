package exp4;

public class exp4_3 {
    public static void main(String[] args) {
        exp4_3_Circle circle=new exp4_3_Circle(3);
        exp4_3_Rectangle rectangle=new exp4_3_Rectangle(3,4);
        exp4_3_Triangle triangle=new exp4_3_Triangle(3,4,5);
        System.out.println("圆:\t面积："+circle.area()+"\t周长："+circle.perimeter());
        System.out.println("矩形:\t面积："+rectangle.area()+"\t周长："+rectangle.perimeter());
        System.out.println("三角形:\t面积："+triangle.area()+"\t周长："+triangle.perimeter());
    }
}
