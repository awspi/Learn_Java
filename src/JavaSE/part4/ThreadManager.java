package JavaSE.part4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ThreadManager {
    private static int  mutex = 1;
    private static String  pingName ;//临界区进程的进程名
    private static int  pingPro=0;//临界区进程的优先级
    private static boolean needQuit=false;//临界区进程是否需要主动退出
    private static int alreadyRuntime;//已经运行时间
    private static int maxRuntime=7000;//运行时间 有限等待时间7秒
    private static Queue<Progress> waitQueue = new LinkedList<>();



        public static void main(String[] args) throws InterruptedException {
        ThreadManager m = new ThreadManager();
        m.init(8000);

    }
    public void init(int maxRuntime){
        this.maxRuntime=maxRuntime;
        System.out.println("临界区准备完成...");
        Thread managerProgress=new Thread(()->{
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (mutex != 0 && !waitQueue.isEmpty()) {//可以进入
                    //占用临界区
                    mutex = 0;
                    Progress p = waitQueue.poll();//现在在临界区的进程

                    pingName = p.name;
                    pingPro = p.pro;

                    alreadyRuntime+=100;//累加运行时间

                    take(p);
                }
                if(mutex!= 0&&!waitQueue.isEmpty()&&alreadyRuntime>maxRuntime){//有限等待
                    needQuit=true;
                    System.out.println("进程" +pingName+" 已经运行了" +alreadyRuntime+"ms >=最大等待时间"+maxRuntime+"ms 需要提前退出临界区...");
                }
            }
        });
        managerProgress.start();
    }

    public static void run(Progress p){
        System.out.println("进程" +"345.exe"+" 请求进入临界区...");
        if(mutex!=1&&p.pro<=pingPro){
            System.out.println("进程" +pingName+"[优先级" +pingPro+"]正在临界区 进程"+p.name+"[优先级" +p.pro+"]等待资源...");
        }
        if(mutex!=1&&p.pro>pingPro){
            System.out.println("进程" +pingName+"[优先级" +pingPro+"]正在临界区 进程"+p.name+"[优先级" +p.pro+"]优先级更高");//让权等待
            needQuit=true;
        }

        waitQueue.add(p);

    }

    public static void take(Progress p){
        Thread t =new Thread(()->{
            Random rand=new Random();
            System.out.println("进程" +p.name+" 进入了临界区...");

            try {
                for(int i=0;i<rand.nextInt(70)+20;i++){ //等待一段时间 随机2-7秒
                    if (needQuit){
                        needQuit=false;
                        System.out.println("进程" +p.name+" 需要提前退出临界区...");
                        break;//不再sleep
                    }
                    Thread.sleep(100);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //进程准备退出
            reduce(p);
        });
        t.start();
    }


    public static void reduce(Progress p){
        mutex=1;
        pingName="";
        pingPro=0;
        alreadyRuntime=0;//运行时间置为零
        System.out.println("进程" +p.name+" 退出了临界区...");
    }
}

