package JavaSE.part4;

import java.io.*;

public class Stream {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test6();
        test6();
        test7();
        test9();
        test10();
    }
    public static void test1(){
        FileInputStream inputStream = null;    //定义可以先放在try外部
        try {
            inputStream = new FileInputStream("src/JavaSE/part4/test.txt");  //路径支持相对路径和绝对路径
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {    //建议在finally中进行，因为这个是任何情况都必须要执行的！
                if(inputStream != null) inputStream.close();//在使用完成一个流之后，必须关闭这个流来完成对资源的释放，否则资源会被一直占用！
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

//    JDK1.7新增了try-with-resource语法，用于简化
    public static void test2(){
         //直接在try()中定义要在完成之后释放的资源,也可以多个
        try(FileInputStream inputStream= new FileInputStream("src/JavaSE/part4/test.txt")) {
            System.out.println((char)inputStream.read());// //读取一个字节的数据（英文字母只占1字节，中文占2字节）
            int temp;
            while ((temp=inputStream.read())!=-1){
                System.out.println((char)temp);
                System.out.println(inputStream.available());  //查看剩余数量
            }
        }catch (IOException e){//这里变成IOException是因为调用close()可能会出现，而FileNotFoundException是继承自IOException的
            e.printStackTrace();
        }    //无需再编写finally语句块，因为在最后自动帮我们调用了close()
    }

//    一次性全部读取呢？我们可以预置一个合适容量的byte[]数组来存放。
    public static void test3(){
        try(FileInputStream inputStream = new FileInputStream("src/JavaSE/part4/test.txt")) {
//            inputStream.skip(1);
//            System.out.println((char) inputStream.read());   //跳过了一个字节
            byte[] bytes = new byte[inputStream.available()];   //我们可以提前准备好合适容量的byte数组来存放
            System.out.println(inputStream.read(bytes));   //一次性读取全部内容（返回值是读取的字节数）
//            System.out.println(inputStream.read(bytes, 1, 2));   //第二个参数是从给定数组的哪个位置开始放入内容，第三个参数是读取流中的字节数
            System.out.println(new String(bytes));   //通过String(byte[])构造方法得到字符串
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //文件输出流
    public static void test4(){
        //输出流也需要在最后调用close()方法，并且同样支持try-with-resource
        try(FileOutputStream outputStream = new FileOutputStream("src/JavaSE/part4/output.txt")) {
            //注意：若此文件不存在，会直接创建这个文件！
            outputStream.write('A');   //同read一样，可以直接写入内容
            outputStream.write("Pithy".getBytes());//也可以直接写入byte[]
            outputStream.flush();  //建议在最后执行一次刷新操作（强制写入）来保证数据正确写入到硬盘文件中
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    ////在文件尾部进行追加写入数据
    public static void test5(){

        try(FileOutputStream outputStream = new FileOutputStream("src/JavaSE/part4/output.txt", true)) {//append true
            outputStream.write("_".getBytes());   //现在只会进行追加写入，而不是直接替换原文件内容
            outputStream.flush();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    public static void test6(){
        try(FileOutputStream outputStream = new FileOutputStream("src/JavaSE/part4/output.txt");
            FileInputStream inputStream = new FileInputStream("src/JavaSE/part4/test.txt")) {   //可以写入多个
            byte[] bytes = new byte[10];    //使用长度为10的byte[]做传输媒介
            int tmp;   //存储本地读取字节数
            while ((tmp = inputStream.read(bytes)) != -1){   //直到读取完成为止
                outputStream.write(bytes, 0, tmp);    //写入对应长度的数据到输出流
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    //### 文件字符流 字符流是以一个具体的字符进行读取，因此它只适合读纯文本的文件
    public static void test7(){
        try(FileReader reader = new FileReader("src/JavaSE/part4/test.txt");
        FileWriter writer=new FileWriter("src/JavaSE/part4/output.txt")){
            reader.skip(1);   //现在跳过的是一个字符
            System.out.println((char) reader.read());   //现在是按字符进行读取，而不是字节，因此可以直接读取到中文字符
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    //只支持`char[]`类型作为存储：
    public static void test9(){
        try(FileReader reader = new FileReader("src/JavaSE/part4/test.txt");
        FileWriter writer=new FileWriter("src/JavaSE/part4/output.txt")){
            char[] str = new char[10];
            reader.read(str);
            System.out.println(str);   //直接读取到char[]中
            //Writer：
            writer.getEncoding();   //支持获取编码（不同的文本文件可能会有不同的编码类型）
            writer.write('啊');
            writer.append('这');   //其实功能和write一样
            writer.flush();   //刷新

        }catch (IOException e){
            e.printStackTrace();
        }

    }

    //Reader和Writer 拷贝纯文本文件
    public static void test10(){
        try(FileReader reader = new FileReader("src/JavaSE/part4/test.txt");
            FileWriter writer=new FileWriter("src/JavaSE/part4/output.txt")){
            char[] chars = new char[10];
            int temp;
            while (((temp=reader.read(chars))!=-1)){
                writer.write(chars,0,temp);
            }
            writer.flush();   //刷新
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    public static void test11(){

    }
    public static void test12(){

    }

}
