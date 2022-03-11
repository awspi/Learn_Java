package JavaSE.part2.Other;

public class Enum {
    public static void main(String[] args) {
        Student student = new Student("小明", 18);
        student.setStatus(Status.RUNNING);
        System.out.println(Status.valueOf("SLEEP"));///将名称相同的字符串转换为枚举
        for (Status val:Status.values()){//快速获取所有的枚举
            System.out.println(val);
        }
    }

}
