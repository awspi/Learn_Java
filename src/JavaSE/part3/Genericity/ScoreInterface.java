package JavaSE.part3.Genericity;
//泛型不仅仅可以可以定义在类上，同时也能定义在接口上：
public interface ScoreInterface<T> {
    T getScore();
    void setScore(T t);

}
