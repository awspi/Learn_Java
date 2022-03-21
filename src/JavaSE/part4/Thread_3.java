package JavaSE.part4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;

//定时器Timer
public class Thread_3 {
    public static void main(String[] args) throws InterruptedException{
//        custom();
        test1();
//        test2();
        test3();
        test4();
    }

    public static void custom(){
        new TimerTask(() -> System.out.println("我是定时任务！"), 3000).start();   //创建并启动此定时任务
        new TimerLoopTask(() -> System.out.println("我是定时任务！"), 3000).start();   //创建并启动此定时任务
    }

    //自行封装一个TimerTask类，并在启动时，先休眠3秒钟，再执行我们传入的内容。
     static class TimerTask{
        Runnable task;
        long time;

        public TimerTask(Runnable runnable, long time){
            this.task = runnable;
            this.time = time;
        }

        public void start(){
            new Thread(() -> {
                try {
                    Thread.sleep(time);
                    task.run();   //休眠后再运行
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }
    
    //每隔1秒钟执行一次代码
    static class TimerLoopTask{
        Runnable task;
        long loopTime;

        public TimerLoopTask(Runnable runnable, long loopTime){
            this.task = runnable;
            this.loopTime = loopTime;
        }

        public void start(){
            new Thread(() -> {
                try {//将单次执行放入到一个无限循环中，这样就能一直执行了，并且按照我们的间隔时间进行。
                    while (true){   //无限循环执行
                        Thread.sleep(loopTime);
                        task.run();   //休眠后再运行
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }


    //我们可以通过创建一个Timer类来让它进行定时任务调度，我们可以通过此对象来创建任意类型的定时任务，延时任务、循环定时任务等
    public static void test1(){
        Timer timer=new Timer();
        timer.schedule(new java.util.TimerTask() {//注意这个是一个抽象类，不是接口，无法使用lambda表达式简化，只能使用匿名内部类
                    @Override
                        public void run() {
                        System.out.println(Thread.currentThread().getName());
                    }
                },1000);//执行一个延时任务
    }
    //我们发现，虽然任务执行完成了，但是我们的程序并没有停止，这是因为Timer内存维护了一个任务队列和一个工作线程


    //todo 创建任意类型的定时任务，延时任务、循环定时任务等



    //守护线程 .setDaemon(true);
    public static void test2() throws InterruptedException{
        Thread t = new Thread(() -> {
            Thread it = new Thread(() -> { //子线程
                while (true){
                    try {
                        System.out.println("程序正常运行中..."); //在守护线程中产生的新线程也是守护的
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            it.start();
        });
        t.setDaemon(true);   //设置为守护线程（必须在开始之前，中途是不允许转换的）
        t.start();
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
        }
    }


    //集合类并行方法
    public static void test3(){
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 4, 5, 2, 9, 3, 6, 0));
        list
                .parallelStream()    //获得并行流 更合理利用计算机多核 同时需要注意多线程产生的异步问题
                .forEach(i -> System.out.println(Thread.currentThread().getName()+" -> "+i));
        //forEach操作的顺序，并不是我们实际List中的顺序，同时每次打印也是不同的线程在执行！
        //调用`forEachOrdered()`方法来使用单线程维持原本的顺序
    }
    public static void test4(){
        int[] arr = new int[]{1, 4, 5, 2, 9, 3, 6, 0};
        Arrays.parallelSort(arr);   //parallel使用多线程进行并行排序，效率更高
        System.out.println(Arrays.toString(arr));
        Arrays.parallelSetAll(arr,i->{
            System.out.println(Thread.currentThread().getName());
            return arr[i];
        });
        System.out.println(Arrays.toString(arr));
    }
}

