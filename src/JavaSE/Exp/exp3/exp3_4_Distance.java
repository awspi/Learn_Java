package JavaSE.Exp.exp3;

import java.util.Scanner;

public class exp3_4_Distance {
    double distance; // 两点之间的距离
    Scanner reader = new Scanner(System.in);

    double twoPointDistance(exp3_4_MyPoint point1,exp3_4_MyPoint point2) {

        double i=(point1.x-point2.x)*(point1.x-point2.x)+(point1.y-point2.y)*(point1.y-point2.y);//暂存距离的平方

        distance = Math.sqrt(i); //开方

        return distance;

    }

    void getDistance() {//输出距离值
        System.out.println(distance);
    }

}
