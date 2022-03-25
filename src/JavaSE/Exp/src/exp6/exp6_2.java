package exp6;

public class exp6_2 {

    public static void main(String[] args) {
        String s = "1啊2啊34啊56啊78";//定义并赋值s
        String c = "";//初始化新字符串
        for (int i = 0; i < s.length(); i++) {//访问s字符串把其中数字字符放入c字符串
            if (s.charAt(i) >= 48 && s.charAt(i) <= 57) {
                c = c + s.charAt(i);
            }
        }
        System.out.print(c);
    }
}
