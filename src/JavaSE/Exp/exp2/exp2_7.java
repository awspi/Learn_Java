package JavaSE.Exp.exp2;
//编写程序，求出几何形状（长方形、正方形、圆形）的周长和面积。
public class exp2_7 {
    public static void main(String[] args) {
        int circle_r = 3, rectangle_l = 3, rectangle_w = 4;
        int rectangle_C1 = (rectangle_l + rectangle_w) * 2;//长方形的周长
        int rectangle_C2 = rectangle_l * 4;                //正方形的周长
        double circle_C = 2 * circle_r * Math.PI;          //圆的周长
        double rectangle_S1 = rectangle_l * rectangle_w;   //长方形的面积
        double rectangle_S2 = rectangle_l * rectangle_l;   //正方形的面积
        double circle_S = circle_r * circle_r * Math.PI;   //圆的面积
        System.out.print("长为3，宽为4的长方形的周长："+rectangle_C1+"\n");
        System.out.print("长为3，宽为4的长方形的面积："+rectangle_S1+"\n");
        System.out.print("边长为3的正方形的周长："+rectangle_C2+"\n");
        System.out.print("边长为3的正方形的面积："+rectangle_S2+"\n");
        System.out.print("半径为3的圆的周长："+circle_C+"\n");
        System.out.print("半径为3的圆的面积："+circle_S+"\n");
    }
}
