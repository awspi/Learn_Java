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
 public Score(String name, String id, T score) {   //提供的score类型即为T代表的类型
        this.name = name;
        this.id = id;
        this.score = score;
    }
}
