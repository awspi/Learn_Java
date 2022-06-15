package JavaSE.part4;

import java.util.ArrayList;
import java.util.List;

public class Thread_2 {
    public static void main(String[] args) throws InterruptedException{
//        t1();
        t2();
//        t3();
//        t4();
//        t5();
//        t6();
//        t7();

    }
    //线程锁
    private static int value = 0;
    private static List<String> list =new ArrayList<>();
    public static void t1() throws InterruptedException{
        //通过synchronized关键字来创造一个线程锁
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
//                synchronized (){ 需要在括号中填入一个内容，必须是一个对象或是一个类
//                  ...
//                }
                synchronized (Thread_2.class){ //synchronized是一种悲观锁，随时都认为有其他线程在对数据进行修改，如果有其他线程占用会一直等待
                    value++;
                }
            }
            System.out.println("线程1完成");
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                synchronized (Thread_2.class){
                    value++;
                }
            }
            System.out.println("线程2完成");
        });
        t1.start();
        t2.start();
        Thread.sleep(1000);  //主线程停止1秒，保证两个线程执行完成
        System.out.println(value);
        //在同步代码块执行过程中，拿到了我们传入对象或类的锁,，但是注意两个线程必须使用同一把锁！
        // 传入的如果是对象，就是对象锁，不同的对象代表不同的对象锁，如果是类，就是类锁，类锁只有一个，实际上类锁也是对象锁，是Class类实例，但是Class类实例同样的类无论怎么获取都是同一个）
        //
        // 当一个线程进入到同步代码块时，会获取到当前的锁，而这时如果其他使用同样的锁的同步代码块也想执行内容，就必须等待当前同步代码块的内容执行完毕，
        //在执行完毕后会自动释放这把锁，而其他的线程才能拿到这把锁并开始执行同步代码块里面的内容。



    }
    public static void t2() throws InterruptedException {
        Thread_2  main1 = new Thread_2();
        Thread_2 main2 = new Thread_2();
        Thread t1 = new Thread(() -> {
            System.out.println("进程1请求进入临界区…");
            while(true){
              if(value==1){
                  break;
              }
            };
            for (int i = 0; i < 10000; i++) {
                synchronized (main1){//
                    value++;
                }
            }
            System.out.println("线程1退出");
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                synchronized (main2){//当对象不同时，获取到的是不同的锁
                    value++;
                }
            }
            System.out.println("线程2完成");
        });
        //进程x请求进入临界区…
        t1.start();
        t2.start();
//        Thread.sleep(1000);  //主线程停止1秒，保证两个线程执行完成
        System.out.println(value);

    }

    //synchronized关键字也可以作用于方法上，调用此方法时也会获取锁：
    //只不过这个锁不用你去给，如果是静态方法，就是使用的类锁，
    // 而如果是普通成员方法，就是使用的对象锁。
    private static synchronized void add(){
        value++;
    }//synchronized
    public static void t3() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) add();
            System.out.println("线程1完成");
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) add();
            System.out.println("线程2完成");
        });
        t1.start();
        t2.start();
        Thread.sleep(1000);  //主线程停止1秒，保证两个线程执行完成
        System.out.println(value);

    }


    //死锁 指两个线程相互持有对方需要的锁，但是又迟迟不释放，导致程序卡住
    //线程A和线程B都需要对方的锁，但是又被对方牢牢把握，由于线程被无限期地阻塞，因此程序不可能正常终止

    public static void t4(){
        System.out.println("死锁");
        Object o1 = new Object();
        Object o2 = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (o1){//占有o1 请求o2
                try {
                    Thread.sleep(1000);
                    synchronized (o2){
                        System.out.println("线程1");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (o2){//占有o2 请求o1
                try {
                    Thread.sleep(1000);
                    synchronized (o1){
                        System.out.println("线程2");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();

    }


    //Object类还有三个方法我们从来没有使用过，分别是`wait()`、`notify()`以及`notifyAll()`，他们其实是需要配合synchronized来使用

    public static void t5() throws InterruptedException{
        Object o1 = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (o1){
                try {
                    System.out.println("开始等待");
                    o1.wait();                      //进入等待状态并释放锁
                    System.out.println("等待结束！");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (o1){
                System.out.println("开始唤醒！");
                o1.notify();                        //唤醒处于等待状态的线程
                for (int i = 0; i < 50; i++) {
                    System.out.println(i);
                }
                //唤醒后依然需要 等待这里的锁释放之前等待的线程 才能继续
            }
        });
        t1.start();
        Thread.sleep(1000);
        t2.start();

        //，对象的`wait()`方法会暂时使得此线程进入等待状态，同时会释放当前代码块持有的锁，这时其他线程可以获取到此对象的锁
        // 当其他线程调用对象的`notify()`方法后，会唤醒刚才变成等待状态的线程（这时并没有立即释放锁）。
        // 注意，必须是在持有锁（同步代码块内部）的情况下使用，否则会抛出异常！

        //notifyAll其实和notify一样，也是用于唤醒，
        // 但是前者是唤醒所有调用`wait()`后处于等待的线程，而后者是看运气随机选择一个唤醒。

    }



    //ThreadLocal 只在自己的工作内存中创建变量仅供线程自己使用
    //使用ThreadLocal类，来创建工作内存中的变量，它将我们的变量值存储在内部（只能存储一个变量），
    // 不同的变量访问到ThreadLocal对象时，都只能获取到自己线程所属的变量。
    public static void t6() throws InterruptedException{
        ThreadLocal<String> local = new ThreadLocal<>();  //注意这是一个泛型类，存储类型为我们要存放的变量类型
        Thread t1 = new Thread(() -> {
            local.set("PITHY");   //将变量的值给予ThreadLocal
            System.out.println("变量值已设定！");
            System.out.println(local.get());   //尝试获取ThreadLocal中存放的变量
        });
        Thread t2 = new Thread(() -> {
            System.out.println(local.get());   //尝试获取ThreadLocal中存放的变量 无法获取 null
        });
        Thread t3 = new Thread(() -> {
            local.set("AWSPI");
            System.out.println(local.get());   //尝试获取ThreadLocal中存放的变量 可以获取自己进程的变量
        });
        t1.start();
        Thread.sleep(1000);    //间隔三秒
        t2.start();
        Thread.sleep(1000);    //间隔三秒
        t3.start();
        //不同线程向ThreadLocal存放数据，只会存放在线程自己的工作空间中，而不会直接存放到主内存中，因此各个线程直接存放的内容互不干扰。
    }

    //线程中创建的子线程，无法获得父线程工作内存中的变量
    public static void t7(){
        ThreadLocal<String> local = new ThreadLocal<>();
        Thread t = new Thread(() -> {
            local.set("ABCD");
            new Thread(() -> {
                System.out.println(local.get());//null
            }).start();
        });
        t.start();

        ThreadLocal<String> local2 = new InheritableThreadLocal<>();//可以使用InheritableThreadLocal来解决
        Thread t2 = new Thread(() -> {
            local2.set("ABCD");
            new Thread(() -> {
                System.out.println(local2.get());
            }).start();
        });
        t2.start();
    }
}
