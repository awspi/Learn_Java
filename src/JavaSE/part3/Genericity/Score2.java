package JavaSE.part3.Genericity;
//当实现此接口时，我们可以选择在实现类明确泛型类型或是继续使用此泛型，
// 让具体创建的对象来确定类型。
public class Score2<T> implements ScoreInterface<T>{
    private final String name;
    private final String id;
    private T score;
    public Score2(String name, String id,T score){
        this.id=id;
        this.name=name;
        this.score=score;

    }
    @Override
    public T getScore() {
        return score;
    }

    @Override
    public void setScore(T t) {
    this.score=score;
    }
}
