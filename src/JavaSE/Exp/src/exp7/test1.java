package JavaSE.exp.src.exp7;

public class test1 {
    static class a{
        int a;
        void fun1(){
            System.out.println("class a"+a);
        }

    }
    static class b extends a{
        int a ;
        void fun1(){
            System.out.println("class b"+a);
        }
    }

    public static void main(String[] args) {
         int a;
        b xx=new b();
        xx.a=22;
        a x= new a();
        x.a=11;
        x=xx;
        System.out.println(x.a);
        x.fun1();

    }
}
