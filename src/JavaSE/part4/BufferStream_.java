package JavaSE.part4;
//缓冲流
import java.io.*;

public class BufferStream_ {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
    }

    //BufferedInputStream
    public static void test1(){
        //将原本的流作为构造参数传入BufferedInputStream即可
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("src/JavaSE/part4/test.txt"))){   //传入FileInputStream
            System.out.println((char) bufferedInputStream.read());   //操作和原来的流是一样的
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    //reset()`和`mark()`
    public static void test2(){
        //当调用`mark()`之后，输入流会以某种方式保留之后读取的`readlimit`数量的内容，
        // 当读取的内容数量超过`readlimit`则之后的内容不会被保留，当调用`reset()`之后，会使得当前的读取位置回到`mark()`调用时的位置。
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("src/JavaSE/part4/test.txt"))){
            bufferedInputStream.mark(1);   //只保留之后的1个字符
            System.out.println((char) bufferedInputStream.read());//a
            System.out.println((char) bufferedInputStream.read());//b
            bufferedInputStream.reset();   //回到mark时的位置
            System.out.println((char) bufferedInputStream.read());//a
            System.out.println((char) bufferedInputStream.read());//b
            //虽然后面的部分没有保存，但是依然能够正常读取，
            //其实`mark()`后保存的读取内容是取`readlimit`和BufferedInputStream类的缓冲区大小两者中的最大值，而并非完全由`readlimit`确定。
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    //限制一下缓冲区大小
    public static void test3(){
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("src/JavaSE/part4/test.txt"), 1)){  //将缓冲区大小设置为1
            bufferedInputStream.mark(1);   //只保留之后的1个字符
            System.out.println((char) bufferedInputStream.read());
            System.out.println((char) bufferedInputStream.read());   //已经超过了readlimit，继续读取会导致mark失效
//            bufferedInputStream.reset();   //mark已经失效，无法reset()
            System.out.println((char) bufferedInputStream.read());
            System.out.println((char) bufferedInputStream.read());
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

//BufferedOutputStream
    public static void test4(){
        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("src/JavaSE/part4/output.txt"))){
            outputStream.write("SAD".getBytes());
            outputStream.flush();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

//缓冲字符流
    public static void test5(){
        try (BufferedReader reader = new BufferedReader(new FileReader("src/JavaSE/part4/test.txt"))){
            System.out.println(reader.readLine());//使用和reader也是一样的，支持按行读取：
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    //把每一行内容依次转换为集合类提到的Stream流：
    public static void test6(){
        try (BufferedReader reader = new BufferedReader(new FileReader("src/JavaSE/part4/test.txt"))){
            reader
                    .lines()
                    .limit(2)
                    .distinct()
                    .sorted()
                    .forEach(System.out::println);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    //它同样也支持`mark()`和`reset()`操作：
    public static void test7(){
        try (BufferedReader reader = new BufferedReader(new FileReader("src/JavaSE/part4/test.txt"))){
            reader.mark(1);
            System.out.println((char) reader.read());
            reader.reset();
            System.out.println((char) reader.read());
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    //BufferedWriter处理文本
    public static void test8(){
        try (BufferedWriter reader = new BufferedWriter(new FileWriter("output.txt"))){
            reader.newLine();   //使用newLine进行换行
            reader.write("awesomepink");   //可以直接写入一个字符串
            reader.flush();   //清空缓冲区
        }catch (IOException e) {
            e.printStackTrace();
        }
    }


}
