package JavaSE.part2.Package;

//### 包声明和导入
//包其实就是用来区分类位置的东西，也可以用来将我们的类进行分类，类似于C++中的namespace
import JavaSE.part2.OOP.Student;//如果需要使用其他包里面的类，那么我们需要`import`
import static JavaSE.part2.OOP.Student.abc;//静态导入可以直接导入某个类的静态方法或者是静态变量，导入后，相当于这个方法或是类在定义在当前类中，可以直接调用该方法

public class Test {
    public static void main(String[] args) {
        Student stu =new Student();
        Worker w1=new Worker();
//        w1.work();//todo


//        System.out.println(w1.a); a 在 JavaSE.part2.Package.Worker 中是 private 访问控制
        abc();
        ability ab1=new ability();
        ab1.description="slide water";
        ab1.expense=0;
        Worker w2=new Worker(ab1);
        w2.work();
    }

}