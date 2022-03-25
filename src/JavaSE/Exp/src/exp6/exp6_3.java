package exp6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class exp6_3 { //Pattern与Matcher一起合作.Matcher类提供了对正则表达式的分组支持,以及对正则表达式的多次匹配支持
    public static void main(String[] args) {
        String s = "数学87分， 物理76分，英语96分";
        String re = "[1234567890.]+" ;//正则表达式
        Pattern p = Pattern.compile(re) ;
        Matcher m = p.matcher(s) ;
        double sum = 0 ;
        while (m.find()) {
            String item = m.group() ;
            System.out.println(item) ;
            sum=sum+Double.parseDouble(item) ;
        }
        System.out.println("总成绩："+sum+"平均成绩为"+sum/3) ;
    }

}
