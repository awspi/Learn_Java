package JavaSE.part2.InnerClass;

import JavaSE.part2.Class.Eat;

public class Main {
    public static void main(String[] args) {
        //内部类
        Test test = new Test();
        Test.Inner1 inner = test.new Inner1();   //写法有那么一丝怪异，但是没毛病！
        //匿名内部类 无法实现复用
        //是在new的时候，直接对接口或是抽象类的实现：
        Eat eat=new Eat() {
            @Override
            public void eat() {
                System.out.println("匿名内部类");
            }
        };
        eat.eat();

        //lambda表达式 相当于接口匿名实现的简化
        //只能访问外部 的final类型 或是 隐式final类型 的局部变量！
        int n=1;
        n++;
        int finaln=n;
        A e= a -> null;
        A ee= a -> {
            System.out.println("123");
//            return a+n+"1";//lambda 表达式中使用的变量应为 final 或有效 final
            return a+finaln+"1";
        };
        System.out.println(ee.test(1));
    }
}
