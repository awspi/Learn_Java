package JavaSE.part2.OOP;

public class Test {
    void swap(int a,int b){
        int temp=b;
        b=a;
        a=temp;
    }
    //
    void printName(Student s){
        System.out.println(s.name);
    }

    int r(){   //原本的方法
        System.out.println("原本的方法");
        return 1;
    }

    int r(int i){  //ok，形参不同
        System.out.println("调用了int");
        return i;
    }

    void r(byte i){  //ok，返回类型和形参都不同

    }
    void r(double i){
        System.out.println("调用了double");
    }
//    void r(){  //错误，仅返回值类型名称不同不能重载
//
//    }


}
