package JavaSE.part2.OOP;

public class Teacher {
//代码块在对象创建时执行，也是属于类的内容，但是它在构造方法执行之前执行（和成员变量初始值一样）
// 且每 创建一个对象 时，只执行一次！（相当于构造之前的准备工作）
    {
        System.out.println("代码块ing");
    }
    //静态代码块和上面的静态方法和静态变量一样，在 类 刚加载时就会调用；
    static{
        System.out.println("静态代码块ing");
    }

    String name="Kk";
    int age;
    static String  company=test(); //直接调用方法，只能调用静态方法
    //所有被标记为静态的内容，会在类刚加载的时候就分配，而不是在对象创建的时候分配，所以说静态内容一定会在第一个对象初始化之前完成加载。
    static String test(){
        System.out.println("初始化变量company");
        return "company=HAUT";
    }
    static int a=get_a();
    static int get_a(){
        return a;
    }
    /*
    定义和赋值是两个阶段，在定义时会使用默认值（上面讲的，类的成员变量会有默认值）
    定义出来之后，如果发现有赋值语句，再进行赋值，
    而这时，调用了静态方法，所以说会先去加载静态方法，静态方法调用时拿到a，而a这时仅仅是刚定义，所以说还是初始值，最后得到0
    */
    public Teacher() {//如果同时需要有参和无参构造，那么就需要用到方法的重载！手动再去定义一个无参构造。
//        成员变量的初始化始终在构造方法执行之前
        System.out.println("构造类对象");
        System.out.println(name);
        System.out.println(company);
    }

    Teacher(String name){//形参和类成员变量冲突了，Java会优先使用形式参数定义的变量！
        this.name=name;//通过this指代当前的对象属性，this就代表当前对象
    }
}
