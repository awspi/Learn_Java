package JavaSE.part2.Exp.Person;

import JavaSE.part2.Exp.Exam;

public class Student extends Person implements Exam {


    public Student(String name) {
        super(name);
    }

    @Override
    public void eat(){

    }
    @Override
    public void exercise(){

    }
    @Override
    public void study(){

    }
    @Override
    public void exam(){
        System.out.println("exam-");
    }


}
