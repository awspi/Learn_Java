package JavaSE.part4;

public class Thread_ {
    public static void main(String[] args) throws InterruptedException {
        t1();
        t2();
        t3();
        t4();
        t5();
        t6();
        t7();
        t8();
        t9();
        t10();
        t11();
    }
    ////通过创建Thread对象来创建一个新的线程
    public static void t1(){
        //Thread构造方法中需要传入一个Runnable接口的实现（其实就是编写要在另一个线程执行的内容逻辑）
        // 同时Runnable只有一个未实现方法，因此可以直接使用lambda表达式：
    Thread t=new Thread(() -> System.out.println("RUN"));

        //    Thread t=new Thread(new Runnable(){
        //        @Override
        //        public void run() {
        //            System.out.println("RUN");
        //        }
        //    });

        //创建好后，通过调用`start()`方法来运行此线程：
        t.start();
    }
    public static void t2(){
        //因为他们分别位于两个线程，他们是同时进行的 输出结果并不是按照从上往下的顺序
        Thread t = new Thread(() -> {
            System.out.println("我是线程："+Thread.currentThread().getName());
            System.out.println("我正在计算 0-10000 之间所有数的和...");
            int sum = 0;
            for (int i = 0; i <= 10000; i++) {
                sum += i;
            }
            System.out.println("结果："+sum);
        });
        t.start();
        System.out.println("我是主线程！");
        //////////
        System.out.println("//////////");
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                System.out.println("我是一号线程："+i);
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                System.out.println("我是二号线程："+i);
            }
        });
        t1.start();
        t2.start();
        //打印实际上是在交替进行的，也证明了他们是在同时运行！

        //我们发现还有一个run方法，也能执行线程里面定义的内容，但是run是直接在 当前线程 执行，并不是创建一个线程执行！
//        t1.run();//t1运行完之后才会执行t2
//        t2.start();

    }
    public static void t3()throws InterruptedException{
        ////调用`sleep()`方法来让当前线程休眠一段时间
        System.out.println("l");
        Thread.sleep(1000);    //休眠时间，以毫秒为单位，1000ms = 1s
        System.out.println("b");
        Thread.sleep(1000);
        System.out.println("w");
        Thread.sleep(1000);
        System.out.println("nb!");
        //
        //使用`stop()`方法来强行终止此线程：
        Thread t = new Thread(() -> {
            Thread me = Thread.currentThread();   //获取当前线程对象
            for (int i = 0; i < 50; i++) {
                System.out.println("打印:"+i);
                if(i == 20) me.stop();  //此方法会直接终止此线程
            }
        });
        t.start();
        //虽然`stop()`方法能够终止此线程，但是并不是所推荐的做法 可能导致资源不能完全释放

    }
    private static int value = 0;
    public static void t4() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) value++;
            System.out.println("线程1完成");
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) value++;
            System.out.println("线程2完成");
        });
        t1.start();
        t2.start();
        Thread.sleep(1000);  //主线程停止1秒，保证两个线程执行完成
        System.out.println(value);//value最后的值并不是我们理想的结果 !=20000

    }


    //线程的休眠和中断
    public static void t5(){

        //调用`sleep()`方法来将当前线程进入休眠，使得线程处于等待状态一段时间
        Thread t = new Thread(() -> {
            try {
                System.out.println("l");
                Thread.sleep(1000);   //sleep方法是Thread的静态方法，它只作用于当前线程（它知道当前线程是哪个）
                System.out.println("b");    //调用sleep后，线程会直接进入到等待状态，直到时间结束
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();

    }

    //interrupt 发送通知来告知线程需要中断，让线程自行处理后续
    public static void t6(){
        Thread t = new Thread(() -> {
            System.out.println("线程开始运行！");
            while (true){   //无限循环
                if(Thread.currentThread().isInterrupted()){    //isInterrupted()判断是否存在中断标志
                    break;   //响应中断
                }
            }
            System.out.println("线程被中断了！");
        });
        t.start();
        try {
            Thread.sleep(3000);   //休眠3秒
            t.interrupt();   //调用t的interrupt方法
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //收到中断信号后，复位中断标记，然后继续做我们的事情：
    public static void t7(){
        Thread t = new Thread(() -> {
            System.out.println("线程开始运行！");
            while (true){
                if(Thread.currentThread().isInterrupted()){   //通过`isInterrupted()`可以判断线程是否存在中断标志
                    System.out.println("发现中断信号，复位，继续运行...");
                    Thread.interrupted();  //复位中断标记
                }
            }
        });
        t.start();
        try {
            Thread.sleep(3000);   //休眠3秒，一定比线程t先醒来
            t.interrupt();   //调用t的interrupt方法
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //暂停线程   线程暂时停下，比如等待其他线程执行完成后，再继续运行 suspends()暂停  resume()恢复
    public static void t8(){
        Thread t = new Thread(() -> {
            System.out.println("线程开始运行！");
            Thread.currentThread().suspend();   //暂停此线程
            System.out.println("线程继续运行！");
        });
        t.start();
        try {
            Thread.sleep(3000);   //休眠3秒，一定比线程t先醒来
            t.resume();   //恢复此线程
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //不推荐 容易造成死锁
        //不推荐使用 `suspend() `去挂起线程的原因，是因为` suspend() `在使线程暂停的同时，并不会去释放任何锁资源。
        //其他线程都无法访问被它占用的锁。直到对应的线程执行` resume() `方法后，被挂起的线程才能继续，
        //从而其它被阻塞在这个锁的线程才可以继续执行。
        //但是，如果` resume() `操作出现在` suspend() `之前执行，那么线程将一直处于挂起状态，同时一直占用锁，这就产生了死锁。

    }


    //线程优先级
    //Java程序中的每个线程并不是平均分配CPU时间的，为了使得线程资源分配更加合理，Java采用的是抢占式调度方式，优先级越高的线程，优先使用CPU资源
    //优先级一般分为以下三种：
    //* MIN_PRIORITY   最低优先级
    //* MAX_PRIORITY   最高优先级
    //* NOM_PRIORITY  常规优先级
    public static void t9(){
        Thread t = new Thread(() -> {
            System.out.println("线程开始运行！");
        });
        t.start();
        t.setPriority(Thread.MIN_PRIORITY);  //通过使用setPriority方法来设定优先级
    }//优先级越高的线程，获得CPU资源的概率会越大，不一定优先级越高的线程越先执行！



//    线程的礼让和加入
    public static void t10(){
        Thread t1 = new Thread(() -> {
            System.out.println("线程1开始运行！");
            for (int i = 0; i < 50; i++) {
                if(i % 5 == 0) {
                    System.out.println("让位！");//yield()让位之后，尽可能多的在执行线程2的内容。
                    Thread.yield();
                }
                System.out.println("1打印："+i);
            }
            System.out.println("线程1结束！");
        });
        Thread t2 = new Thread(() -> {
            System.out.println("线程2开始运行！");
            for (int i = 0; i < 50; i++) {
                System.out.println("2打印："+i);
            }
        });
        t1.start();
        t2.start();

    }

    //一个线程等待另一个线程{{执行完成}}后再继续进行
    public static void t11(){
        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+"开始运行！");
            for (int i = 0; i < 50; i++) {
                System.out.println(Thread.currentThread().getName()+"打印："+i);
            }
            System.out.println("线程1结束！");
        });
        Thread t2 = new Thread(() -> {
            System.out.println("线程2开始运行！");
            for (int i = 0; i < 50; i++) {
                System.out.println("2打印："+i);
                if(i == 10){
                    try {
                        System.out.println("线程1加入到此线程！");
                        t1.join();    //在i==10时，让线程1加入，先完成线程1的内容，在继续当前内容 `join()`方法来实现线程的加入
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t1.start();
        t2.start();
        //线程1加入后，线程2等待线程1待执行的内容全部执行完成之后，再继续执行的线程2内容。
        // 注意，线程的加入只是等待另一个线程的完成，并不是将另一个线程和当前线程合并！实际上，t2线程只是暂时处于等待状态，当t1执行结束时，t2才开始继续执行，

    }
}
