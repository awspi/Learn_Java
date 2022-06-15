package JavaSE.part4;

public class Ztest {
    public static void main(String[] args) throws InterruptedException {
        ThreadManager manager=new ThreadManager();
        manager.init(7000);
        manager.run(new Progress("123.exe"));
        Thread.sleep(300);
        manager.run(new Progress("haha.exe"));
    }
}
