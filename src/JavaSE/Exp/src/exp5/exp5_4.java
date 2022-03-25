package exp5;

import java.util.Scanner;

public class exp5_4 {
    interface Computable{
        double ToCompute();
    }
    public static void main(String args[]){
        Computable c1=new Computable() {
            double a,b;
            Scanner sc=new Scanner(System.in);
            //a+b
            @Override
            public double ToCompute() {
                System.out.println("加法");
                a=sc.nextDouble();
                b=sc.nextDouble();
                return a+b;
            }
        };
        Computable c2=new Computable() {
            double a,b;
            Scanner sc=new Scanner(System.in);
            //a*b
            @Override
            public double ToCompute() {
                System.out.println("乘法");
                a=sc.nextDouble();
                b=sc.nextDouble();
                return a*b;
            }
        };

        System.out.println(c1.ToCompute());
        System.out.println(c2.ToCompute());
    }

}


