package JavaSE.part3.Genericity;
//泛型本质上也是一个语法糖，在编译后会被擦除，变回上面的Object类型调用，但是类型转换由编译器帮我们完成，而不是我们自己进行转换（安全）
public class Demo {
    public static void main(String[] args) {
        //直接确定Score的类型是字符串类型的成绩
        Score<String> score = new Score<String>("CS", "20201120", "中");
//        Integer i = score.score;  //编译不通过，因为成员变量score类型被定为String！
//        泛型将数据类型的确定控制在了编译阶段，在编写代码的时候就能明确泛型的类型！如果类型不符合，将无法通过编译！
        String i = score.score;
        System.out.println(score.score);
    }
}
