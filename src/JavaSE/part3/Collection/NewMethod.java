package JavaSE.part3.Collection;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class NewMethod {
    public static void main(String[] args) {
        test();
        test2();
    }

    //`compute`方法：
    public static void test(){
        java.util.Map<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");

        map.compute(1, (k, v) -> {   //compute会将指定Key的值进行重新计算，若Key不存在，v会返回null
            return v+"M";     //这里返回原来的value+M
        });
        map.compute(3, (k, v) -> {  //若Key不存在，v会返回null
            return v+"M";     //这里返回原来的null+M
        });
        map.computeIfPresent(2, (k, v) -> {   //当Key存在时存在则计算并赋予新的值
            return v+"M";     //这里返回原来的value+M
        });

        map.computeIfAbsent(0,k->{  //若不存在则计算并插入新的值
            return "M";
        });

        System.out.println(map);
    }


    //merge方法用于处理数据
    public static void test2(){
        List<Student> students = Arrays.asList(
                new Student("yoni", "English", 80),
                new Student("yoni", "Chiness", 98),
                new Student("yoni", "Math", 95),
                new Student("taohai.wang", "English", 50),
                new Student("taohai.wang", "Chiness", 72),
                new Student("taohai.wang", "Math", 41),
                new Student("Seely", "English", 88),
                new Student("Seely", "Chiness", 89),
                new Student("Seely", "Math", 92)
        );
        java.util.Map<String, Integer> scoreMap = new HashMap<>();
        students.forEach(student -> scoreMap.merge(student.getName(), student.getScore(), (a,b)->a+b));
        scoreMap.forEach((k, v) -> System.out.println("key:" + k + "总分" + "value:" + v));
    }

    static class Student {
        private final String name;
        private final String type;
        private final int score;

        public Student(String name, String type, int score) {
            this.name = name;
            this.type = type;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }

        public String getType() {
            return type;
        }
    }


}
