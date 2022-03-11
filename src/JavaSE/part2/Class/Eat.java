package JavaSE.part2.Class;
//接口只代表某个确切的功能！只包含了一些列方法的具体定义，类可以实现这个接口，表示类支持接口代表的功能
// （类似于一个插件，只能作为一个附属功能加在主体上，同时具体实现还需要由主体来实现）
public  interface Eat {//abstract
    //接口只能包含`public`权限的**抽象方法**！
    int a=0;//接口中变量默认为public static final

    //接口 abstract 方法不能有主体
    default void eat(){//可以通过声明`default`关键字来给抽象方法一个默认实现：

    }

}
