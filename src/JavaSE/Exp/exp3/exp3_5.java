package JavaSE.Exp.exp3;

import java.util.Scanner;

public class exp3_5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        float c = in.nextFloat();
        new exp3_5_rectangle(a,b).getArea();
        new exp3_5_rectangle(a,b).getPerimeter();
        new exp3_5_Triangle(a,b).getArea();
        new exp3_5_Circle(c).getArea();
        new exp3_5_Circle(c).getPerimeter();
    }
}
