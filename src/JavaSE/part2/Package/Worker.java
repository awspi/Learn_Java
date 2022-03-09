package JavaSE.part2.Package;
//Java支持对类属性访问的保护，也就是说，不希望外部类访问类中的属性或是方法，只允许内部调用，这种情况下我们就需要用到权限控制符。
//权限控制符可以声明在方法、成员变量、类前面，一旦声明private，只能类内部访问！
public class Worker {//和文件名称相同的类，只能是public，并且一个java文件中只能有一个public class！
    private int a = 10;   //具有私有访问权限，只能类内部访问
    ability ab;
    Worker(){

    }
    Worker(ability ab){
        this.ab=ab;
    }
    void work(){
        System.out.println("i can "+ab.description);
        System.out.println("it takes "+ab.expense+"hours");
    }
}
class ability{//不能添加权限修饰符！只能是default
    String description;
    int expense;
    ability(){
        expense=0;
        description="sleep";
    }
}
