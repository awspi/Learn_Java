package exp4;

public class exp4_2_Person {
    protected String name;
    protected int age;
    protected char sex;
    exp4_2_Person(String name, int age, char sex){
        this.name=name;
        this.age=age;
        this.sex = sex;
    }
    public String show(){
        return name+"\t"+age+"\t"+sex;
    }
}
