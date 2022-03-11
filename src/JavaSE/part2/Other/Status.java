package JavaSE.part2.Other;

public enum Status{
//    RUNNING, STUDY, SLEEP;    //直接写每个状态的名字即可，分号可以不打，但是推荐打上
//既然枚举类型是普通的类，那么我们也可以给枚举类型添加独有的成员方法
RUNNING("睡觉"), STUDY("学习"), SLEEP("睡觉");   //无参构造方法被覆盖，创建枚举需要添加参数（本质就是调用的构造方法！）
    private final String name;    //枚举的成员变量
    Status(String name){    //覆盖原有构造方法（默认private，只能内部使用！）
        this.name = name;
    }
    public String getName() {   //获取封装的成员变量
        return name;
    }
}
//其实枚举类型的本质就是一个普通的类，但是它继承自Enum类，
// 我们定义的每一个状态其实就是一个public static final的Status类型成员变量！