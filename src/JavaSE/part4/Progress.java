package JavaSE.part4;

public class Progress {
    String name;//进程名
    int pro = 1;//优先级 默认是1
    public Progress(String name){
        this.name=name;
    }
    public Progress(String name,int pro){
        this.name=name;
        this.pro=pro;
    }
}