package exp3;

import java.util.Map;

public class exp3_7_Student {
    private String name;
    private  long  xh;
    private  int age;
    private String genre;
    private exp3_7_Course[] courses;
    exp3_7_Student(String name,long  xh,int age,exp3_7_Course[] courses){
        this.name=name;
        this.xh = xh;
        this.age = age;
        this.courses = courses;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return age;
    }

    public String getGenre() {
        return genre;
    }

    public long getXh() {
        return xh;
    }

    public exp3_7_Course[] getCourses() {
        return courses;
    }

    public void printInf(){
        System.out.println("");
        System.out.println(name+"\t"+xh+"\t年龄："+age);
        for(exp3_7_Course c:courses){
            System.out.println(c.getName()+"\t成绩\t"+c.getScore());
        }
    }
    public int getJavaScore(){
        for(exp3_7_Course c:courses){
            if(c.name=="Java")return c.getScore();
        }
        return 0;
    }

}
