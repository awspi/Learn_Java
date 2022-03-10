package JavaSE.part2.Class;

public class Main {
    public static void main(String[] args) {
        ArtStudent artStudent= new ArtStudent("dnm",3);
        ArtStudent.draw();
        //方法的重写
        new SportStudent("dnm",3).study();
        //静态方法不能重写
        SportStudent.rest();
        Student.rest();
        SportStudent stu1=new SportStudent("dnm",3);
        System.out.println(stu1.getName());
        stu1.changeName();
        SportStudent.name="123";
        System.out.println(stu1.getName());

        fun1();
        fun2();
        fun3();
        fun4();
    }

    public void fun_obj(){
        //所有类都默认继承自Object类，除非手动指定类型，但是依然改变不了最顶层的父类是Object类。
        // 所有类都包含Object类中的方法，比如：
        Object obj = new Object();
        System.out.println(obj.hashCode());  //求对象的hashcode，默认是对象的内存地址
        System.out.println(obj.equals(obj));  //比较对象是否相同，默认比较的是对象的内存地址，也就是等同于 ==
        System.out.println(obj.toString());  //将对象转换为字符串，默认生成对象的类名称+hashcode
    }
    public static void fun1(){//类型转换
        System.out.println("fun1:");
        //类也是支持类型转换的（仅限于存在亲缘关系的类之间进行转换）比如子类可以直接向上转型：
        Student student = new SportStudent("lbw", 20);  //父类变量引用子类实例
        student.study();     //得到依然是具体实现的结果(SportStudent)，而不是当前类型(student)的结果

        //可以把已经明确是由哪个类实现的父类引用，强制转换为对应的类型:
        Student stu = new SportStudent("lbw", 20);  //是由SportStudent进行实现的
        //... do something...
        SportStudent st = (SportStudent)stu;  //让它变成一个具体的子类
        st.exercise();  //调用具体实现类的方法

        //instanceof 子类
        System.out.println(student instanceof SportStudent);
        test(stu);
    }
    private static void test(Student student){//instanceof关键字来进行类型判断
        if (student instanceof SportStudent){
            SportStudent sportsStudent = (SportStudent) student;
            sportsStudent.exercise();
        }else if (student instanceof ArtStudent){
            ArtStudent artStudent = (ArtStudent) student;
            artStudent.draw();
        }
    }


    public static void fun2(){//final关键字
        final int a=10;
//        a=20;//无法将值赋给 final 变量 'a'

    }
    public static void fun3(){
        //抽象类由于不是具体的类定义，因此无法直接通过new关键字来创建对象！
        AbstractWorker w=new AbstractWorker() { //只能直接创建带实现的匿名内部类！
            @Override
            public void test() {

            }
        };
    }
    public static void fun4(){//接口
        //实现接口的类也能通过instanceof关键字判断，也支持向上和向下转型！
        Eat eat=new Worker();
        System.out.println(eat instanceof  Worker);
        Worker w=(Worker) eat;
        w.sleep();
    }

}
