package JavaSE.Exp.exp3;

public class exp3_4 {
    public static void main(String[] args) {
        exp3_4_MyPoint p1=new exp3_4_MyPoint(3,4);
        exp3_4_MyPoint p2=new exp3_4_MyPoint();
        exp3_4_Distance distance=new exp3_4_Distance();
        System.out.println("p1坐标（"+p1.getX() + "," + p1.getY()+"）");
        System.out.println("p2坐标（"+p2.getX() + "," + p2.getY()+"）");
        System.out.println("距离：");
        System.out.println(distance.twoPointDistance(p1, p2));
    }
}
