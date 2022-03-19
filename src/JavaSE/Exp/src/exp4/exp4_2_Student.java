package exp4;

public class exp4_2_Student extends exp4_2_Person {
    private int xh;
    exp4_2_Student(String name, int age, char sex, int xh) {
        super(name, age, sex);//super()' 调用必须是构造函数主体中的第一条语句
        this.xh=xh;
    }
    @Override
    public String show(){
        return name+"\t"+age+"\t"+sex+"\t"+xh;
    }
}
