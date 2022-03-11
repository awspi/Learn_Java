package JavaSE.part3.Exception;

public class Main {
    public static void main(String[] args) {
        // 运行时异常 编译时异常 错误
//出现异常时默认会交给JVM来处理，JVM发现任何异常都会立即终止程序运行，并在控制台打印栈追踪信息
//我们希望能够自己处理出现的问题，让程序继续运行下去，就需要对异常进行捕获
        int[] arr = new int[5];
        try{    //在try块中运行代码
            arr[5] = 1;    //当代码出现异常时，异常会被捕获，并在catch块中得到异常类型的对象
        }catch (ArrayIndexOutOfBoundsException e){   //捕获的异常类型
            //当异常被捕获后，就由我们自己进行处理（不再交给JVM处理），因此就不会导致程序终止运行。
            e.printStackTrace();
            System.out.println("程序运行出现异常！");  //出现异常时执行


            //运行时异常在编译时可以不用捕获，但是编译时异常必须进行处理：
        }
        //
//后面的代码会正常运行
        System.out.println("go on");
        try {
            test(1,0);
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            test2(1,0);
        }catch (Exception e){ //捕获异常指定的类型，会捕获其所有子异常类型：
            e.printStackTrace();
        }


        //当我们希望，程序运行时，无论是否出现异常，都会在最后执行的任务，可以交给finally语句块来处理：
        //try语句块至少要配合catch或finally中的一个：
        System.out.println(test3(1));
    }

    //异常的抛出
    public static int test(int a,int b) throws Exception{//声明抛出的异常类型
        if(b==0) throw new Exception("0不能做除数"); //创建异常对象并抛出异常
        return a/b;//抛出异常会终止代码运行
    }

    //自定义异常
    public static int test2(int a,int b) throws MyException{//声明抛出的异常类型
        if(b==0) throw new MyException("wrong");
        return a/b;
    }·

    //try、catch和finally执行顺序：
    public static int test3(int a){
        try{
//            return a;
            return a/0;
        }catch (Exception e){
            return 0;
        }finally {
            a =  a + 1;
        }
    }
}
