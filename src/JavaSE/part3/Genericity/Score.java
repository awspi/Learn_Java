package JavaSE.part3.Genericity;
//成绩分为两种，一种是以优秀、良好、合格 来作为结果，
// 还有一种就是 60.0、75.5、92.5
// 这样的数字分数，那么现在该如何去设计这样的一个Score类
//1.Object score; 解决了多种类型存储问题 但取值只能进行强制类型转换

//泛型类的定义，实际上就是普通的类多了一个类型参数
public class Score<T>{//泛型的名称一般取单个大写字母，比如T代表Type
    String name;
    String id;
    T score;  //T为泛型，根据用户提供的类型自动变成对应类型
//    static T score1;   //错误，不能在静态成员上定义
    public Score(String name, String id, T score) {   //提供的score类型即为T代表的类型
            this.name = name;
            this.id = id;
            this.score = score;
        }
    public T getScore() {    //若方法的返回值类型为泛型，那么编译器会自动进行推断
        return score;
    }
    public void setScore(T score) {   //若方法的形式参数为泛型，那么实参只能是定义时的类型
        this.score = score;
    }


//    静态方法无法直接使用类定义的泛型
    //泛型定义是在类上的，只有明确具体的类型才能开始使用，也就是创建对象时完成类型确定
    public static <E> void test(E e){   //在方法定义前声明泛型
        System.out.println(e);
    }
    //同理，成员方法也能自行定义泛型，在实际使用时再进行类型确定：
    public <E> void test2(E e){
        System.out.println(e);
    }







}

