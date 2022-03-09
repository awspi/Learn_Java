package JavaSE.part2.String;

public class Main {
    public static void main(String[] args) {
        //字符串类是一个比较特殊的类，他是Java中唯一重载运算符的类！(Java不支持运算符重载，String是特例)
        String str="asd";
        System.out.println(str.toUpperCase());//转为大写
//       ==str.toUpperCase().sout 自动包起来
        System.out.println(str.contains("as"));//是否包含
        String str1="abc";
        String str2="abc";
        System.out.println(str1.equals(str2));//比较相等用equals

        //String的对象直接支持使用`+`或`+=`运算符来进行拼接，并形成新的String对象！（String的字符串是不可变的！）
        String a = "ABCD", b = "efg";
        String l = a+b;
        System.out.println(l);
        //String的拼接有可能会被编译器优化为StringBuilder来减少对象创建（对象频繁创建时很费时间同时占内存的！）
        StringBuilder bulider=new StringBuilder();
        bulider.append("b")
                .append("b")
                .append("CCCCC");
        System.out.println(bulider.toString());

//        str.intern()                                      ####拓展
    }
}
