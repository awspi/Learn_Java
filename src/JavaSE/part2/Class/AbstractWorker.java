package JavaSE.part2.Class;
//抽象类可以使用`abstract`关键字来表明一个方法为抽象方法，也可以定义普通方法
// 抽象方法不需要编写具体实现（无方法体）但是必须由子类实现（除非子类也是一个抽象类）！
public abstract class AbstractWorker {//抽象类
    public abstract void test();  //抽象方法
    //现在只能由子类编写，父类没有定义，更加明确了多态的定义！同一个方法多种实现！
}
