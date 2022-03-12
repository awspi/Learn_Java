package JavaSE.part3.Genericity;
//泛型本质上也是一个语法糖，在编译后会被擦除，变回上面的Object类型调用，但是类型转换由编译器帮我们完成，而不是我们自己进行转换（安全）
public class Demo {

    public static void score(String[] args) {


        //直接确定Score的类型是字符串类型的成绩
        //在定义 泛型类的引用 时，需要明确指出类型：<String>
        Score<String> score = new Score<String>("CS", "20201120", "中");
        //简化代码 钻石运算符<> Score<String> score = new Score<>
//        Integer i = score.score;  //编译不通过，因为成员变量score类型被定为String！
//        泛型将数据类型的确定控制在了编译阶段，在编写代码的时候就能明确泛型的类型！如果类型不符合，将无法通过编译！
        String i = score.score;
        System.out.println(score.score);

        //泛型无法使用基本类型,能使用基本类型的包装类进行替换


        //如果不希望指定类型可以使用?通配符 (一般不用)
        Score<Integer> score1;  //声明泛型为Integer类型
        Score<?> score2 =new Score<String>("CS", "20201120", "中");;   //引用任意泛型的Score类对象
        String s1= (String) score2.getScore();
        Object o = score2.getScore();//只能变为Object
    }

    public static void score1(String[] args) {
//        泛型通配符也支持泛型的界限：
        //通过extends关键字进行上界限定，只有指定类型或指定类型的子类才能作为类型参数。
        //通过super关键字进行下界限定，只有指定类型或指定类型的父类才能作为类型参数。
        Score1<? extends Number> score1=new Score1<Number>("wsp","123",99);;
        Score1<? super Integer> score2=new Score1<Number>("wsp","123",99);//int~number
        //指定了上界后，编译器就将范围从原始类型Object提升到我们指定的上界Number，但是依然无法明确具体类型
        Number n=score1.getScore();

       //全部为上界，一旦确立上界后，编译器会自动将类型提升到上界类型。

    }
}
