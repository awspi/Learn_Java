package JavaSE.part2.Class;
//子类具有父类的全部属性，protected可见但外部无法使用（包括`private`属性，不可见，无法使用），
// 同时子类还能有自己的方法。继承只能继承一个父类，不支持多继承！
public class SportStudent extends Student{
    public static String name;//与父类相同名称的成员
    public SportStudent(String name,int age){
        super(name,age);
    }
    public static void exercise(){
        System.out.println("sleep~~zzz");
    }
    @Override  //声明这个方法是重写的，但是可以不要
    public void study(){
        super.study();//调用父类的方法
        System.out.println("Study a p");
    }
    public static void rest(){
        //方法中访问的默认是 形参列表中 > 当前类的成员变量 > 父类成员变量
        name="smallName";
        System.out.println("ZZzzzZZZZzzzz");
    }
    public void changeName(){
        name="smallName";
    }

}
