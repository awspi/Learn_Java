package exp3;

public class exp3_7 {
    public static void main(String[] args) {

        exp3_7_Course[] c1={new exp3_7_Course("高数A",100),new exp3_7_Course("线代A",100),new exp3_7_Course("英语B",95),new exp3_7_Course("马原A",100),new exp3_7_Course("Java",100)};
        exp3_7_Course[] c2={new exp3_7_Course("高数A",89),new exp3_7_Course("线代A",78),new exp3_7_Course("英语B",78),new exp3_7_Course("马原A",99),new exp3_7_Course("Java",98)};
        exp3_7_Course[] c3={new exp3_7_Course("高数A",87),new exp3_7_Course("线代A",98),new exp3_7_Course("英语B",65),new exp3_7_Course("马原A",88),new exp3_7_Course("Java",78)};
        exp3_7_Course[] c4={new exp3_7_Course("高数A",67),new exp3_7_Course("线代A",98),new exp3_7_Course("英语B",89),new exp3_7_Course("马原A",77),new exp3_7_Course("Java",98)};
        exp3_7_Course[] c5={new exp3_7_Course("高数A",90),new exp3_7_Course("线代A",68),new exp3_7_Course("英语B",95),new exp3_7_Course("马原A",66),new exp3_7_Course("Java",77)};

        exp3_7_Student[] students={new exp3_7_Student("小明",201901,19,c1),new exp3_7_Student("小王",201902,19,c2),new exp3_7_Student("小红",201903,20,c3),new exp3_7_Student("小明",201904,19,c4),new exp3_7_Student("小张",201905,19,c5)};
        int sum=0,sc,s1=0,s2=100;
        String name1=students[0].getName();
        String name2=students[0].getName();
        for(exp3_7_Student s:students){
            s.printInf();
            sc=s.getJavaScore();
            sum+=sc;
            if (sc>s1){name1=s.getName();s1=sc;}
            if (sc<s2){name2=s.getName();s2=sc;}
        }
        System.out.println("\njava平均分："+sum/5);
        System.out.println("java最高分："+name1+"\t"+s1);
        System.out.println("java最低分："+name2+"\t"+s2);
    }

}
