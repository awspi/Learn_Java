package JavaSE.part2.Exp.Person;

public abstract class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public  abstract void eat();
    public  abstract void exercise();
    public  abstract void study();
}
