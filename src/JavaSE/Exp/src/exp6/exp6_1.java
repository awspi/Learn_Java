package exp6;

public class exp6_1 {

        public static void main(String []args) {
            //charAt() 方法用于返回指定索引处的字符。索引范围为从 0 到 length() - 1
            String s="华强：你这瓜保熟吗？";
            System.out.println("字符串为："+s);
            System.out.println("第一个字符："+s.charAt(0));
            System.out.println("最后一个字符："+s.charAt(s.length()-1));

        }
}
