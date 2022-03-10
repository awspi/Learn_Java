package JavaSE.part2.Class;

public class ArtStudent extends Student{
    //每一个子类必须定义一个实现父类构造方法的构造方法，也就是需要在构造方法开始使用`super()`，如果父类使用的是默认构造方法，那么子类不用手动指明。
    public ArtStudent(String name, int age) {
        super(name, age);///必须先通过super关键字（指代父类），实现父类的构造方法！ 必须在最前
    }

    public static void draw(){
        System.out.println("draw a pig ");
    }
}
