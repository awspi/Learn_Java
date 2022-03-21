package JavaSE.part4;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//生产者与消费者
//通过多线程编程，来模拟一个餐厅的2个厨师和3个顾客，假设厨师炒出一个菜的时间为3秒，顾客吃掉菜品的时间为4秒。
public class Exp_Thread {
    private static final List<Object> list=new ArrayList<>();

    public static void main(String[] args)  {
//        list.add(new Object());
//        list.forEach(e-> list.remove(e));//报错 ConcurrentModificationException

        //lambda表达式
        //new Thread(()->{
        //            add();
        //        });
        //等价于new Thread(Exp_Thread::add);


        Thread c1=new Thread(()->{
            add();
        });
        c1.setName("厨师1");
        Thread c2=new Thread(Exp_Thread::add);
        c2.setName("厨师2");
        c1.start();
        c2.start();

        Thread s1=new Thread(Exp_Thread::take);
        s1.setName("顾客1");
        Thread s2=new Thread(Exp_Thread::take);
        s2.setName("顾客2");
        Thread s3=new Thread(Exp_Thread::take);
        s3.setName("顾客3");
        s1.start();
        s2.start();
        s3.start();
    }
    private static void add(){
        while (true){
            try {
                Thread.sleep(3000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (list){
                list.add(new Object());
                System.out.println(new Date()+Thread.currentThread().getName()+"添加了新菜");
                list.notify();
            }
        }
    }
    private static void take(){
        while (true){
            try {
                synchronized (list){
                    Thread.sleep(4000);
                    while (list.isEmpty()) list.wait();//不能用if因为if只判断一次，需要一直等待到!=empty
                    list.remove(0);
                    System.out.println(new Date()+Thread.currentThread().getName()+"取走了菜");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
