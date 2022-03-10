package JavaSE.part2.Class;
//推荐在不会再发生改变的成员属性上添加final关键字，JVM会对添加了final关键字的属性进行优化
// 类通过`implements`关键字来声明实现的接口！每个接口之间用逗号隔开！
public final class Worker implements Eat{///类被声明为终态,则不可继承

    public final int salary;//类的成员属性被声明为final，那么必须在构造方法中或是在定义时赋初始值！
    public final String company="haut";

    public Worker() {
        salary = 1;
    }

    public final void sleep(){  //不能重写
        System.out.println("3hours");
    }

}
