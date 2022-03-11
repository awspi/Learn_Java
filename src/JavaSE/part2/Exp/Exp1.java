package JavaSE.part2.Exp;

import JavaSE.part2.Exp.Person.Person;
import JavaSE.part2.Exp.Person.Student;

//对象设计（面向对象、多态运用）
//设计一个Person抽象类，包含吃饭运动学习三种行为，分为工人、学生、老师三种职业。
//设计设计一个接口考试，只有老师和学生会考试。
//设计一个方法，模拟让人类进入考场，要求只有会考试的人才能进入，并且考试。
public class Exp1 {
    public static void main(String[] args) {
        Student stu1=new Student("p");
        stu1.exam();

    }
    private static void test(Person person){
        if (person instanceof Exam){
            Exam e=(Exam) person;
            e.exam();
        }
    }
}
