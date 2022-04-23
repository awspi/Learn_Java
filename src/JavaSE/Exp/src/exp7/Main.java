package JavaSE.exp.src.exp7;

public class Main extends Base {
    void f(String s) {System.out.println("String"); }
    void f(long i) {System.out.println(i); }
    public static void main(String argv[]){
        Main a = new Main();
        a.f(10);
    }}