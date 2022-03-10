package JavaSE.part2.Class;

public class Student {//封装
    //封装的目的是为了保证变量的安全性，使用者不必在意具体实现细节，而只是通过外部接口即可访问类的成员
    //因此在编写类时一般将成员变量私有化，外部类需要同getter和setter方法来查看和设置变量。
    private String name;
    private int age;
    public Student(String name,int age){
        this.name=name;
        this.age=age;
    }
    public void study(){//override
        System.out.println("studying");
    }
    public static void rest(){//静态方法
        System.out.println("drink water");
    }
    public String getName(){
        return name;
    }
    public  int getAge(){
        return age;
    }
    //外部现在只能通过调用我定义的方法来获取成员属性，而我们可以在这个方法中进行一些额外的操作
    public void setName(String name){
        if(name.contains("w")) return;
        this.name=name;
    }
    //单独给外部开放设置名称的方法，因为还需要做一些额外的处理，所以说不能给外部直接操作成员变量的权限！
    //封装思想其实就是把实现细节给隐藏了，外部只需知道这个方法是什么作用，而无需关心实现。
    //封装就是通过访问权限控制来实现的
}
