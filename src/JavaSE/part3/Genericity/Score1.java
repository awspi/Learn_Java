package JavaSE.part3.Genericity;
//    泛型的界限
//通过extends关键字进行上界限定，只有指定类型或指定类型的子类才能作为类型参数。
public class Score1<T extends Number> {   //设定泛型上界，必须是Number的子类
    private final String name;
    private final String id;
    private T score;

    public Score1(String name, String id, T score) {
        this.name = name;
        this.id = id;
        this.score = score;
    }

    public T getScore() {
        return score;
    }
}