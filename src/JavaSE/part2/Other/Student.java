package JavaSE.part2.Other;

public class Student {
    private final String name;
    private final int age;
    private Status status;//如果我们仅仅是存储字符串，似乎外部可以不按照我们规则，传入一些其他的字符串。这显然是不够严谨的！
    //有没有一种办法，能够更好地去实现这样的状态标记呢？可以使用枚举类拿到使用的就是我们定义好的状态！


    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }
}
