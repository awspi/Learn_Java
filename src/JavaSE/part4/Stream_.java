package JavaSE.part4;

import java.io.*;

// 转换流 打印流 数据流 对象流
public class Stream_ {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();

    }
    //InputStreamReader和OutputStreamWriter本质也是Reader和Writer，因此可以直接放入BufferedReader来实现更加方便的操作。

    public static void test1(){
        try(OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("src/JavaSE/part4/test.txt"))){
            //虽然给定的是FileOutputStream，但是现在支持以Writer的方式进行写入
            writer.write("PITHY");   //以操作Writer的样子写入OutputStream
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    //只拿到了一个InputStream，但是我们希望按字符的方式读取，我们就可以使用InputStreamReader
    public static void test2(){
        try(InputStreamReader reader = new InputStreamReader(new FileInputStream("src/JavaSE/part4/test.txt"))){  //虽然给定的是FileInputStream，但是现在支持以Reader的方式进行读取
            System.out.println((char) reader.read());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //打印流
    //PrintStream也永远不会抛出异常，而是使用内部检查机制`checkError()`方法进行错误检查。
    // 最方便的是，它能够格式化任意的类型，将它们以字符串的形式写入到输出流。
    public static void test3(){
        try(PrintStream stream = new PrintStream(new FileOutputStream("src/JavaSE/part4/test.txt"))){
            stream.println("HAHAHA");   //其实System.out就是一个PrintStream
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    //数据流
    //数据流DataInputStream也是FilterInputStream的子类，同样采用装饰者模式，最大的不同是它支持基本数据类型的直接读取
    public static void test4(){
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream("src/JavaSE/part4/test.txt"))){
            System.out.println(dataInputStream.readBoolean());   //直接将数据读取为任意基本数据类型
        }catch (IOException e) {
            e.printStackTrace();
        }

        //写入基本数据类型
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("src/JavaSE/part4/output.txt"))){
            dataOutputStream.writeBoolean(false);
        }catch (IOException e) {
            e.printStackTrace();
        }
        //写入的是二进制数据，并不是写入的字符串，使用DataInputStream可以读取，一般他们是配合一起使用的。
    }

    //对象流
    //ObjectOutputStream不仅支持基本数据类型，通过对对象的序列化操作，以某种格式保存对象，来支持对象类型的IO
    // 注意：它不是继承自FilterInputStream的。
    public static void test5(){
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("src/JavaSE/part4/output.txt"));
             ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("src/JavaSE/part4/output.txt"))){

            People people = new People("AWESOME");

            outputStream.writeObject(people);
            outputStream.flush();

            people = (People) inputStream.readObject();

            System.out.println(people.name);
        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static class People implements Serializable{   //implements Serializable 必须实现Serializable接口才能被序列化
        //在我们后续的操作中，有可能会使得这个类的一些结构发生变化，而原来保存的数据只适用于之前版本的这个类，
        //serialVersionUID区分类的不同版本，当发生版本不匹配时，会无法反序列化为对象：
        private static final long serialVersionUID = 123456;   //在序列化时，会被自动添加这个属性，它代表当前类的版本，我们也可以手动指定版本。
        String name;
        public People(String name){this.name = name;}
    }


    public static void test6(){//不希望某些属性参与到序列化中进行保存
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("src/JavaSE/part4/output.txt"));
             ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("src/JavaSE/part4/output.txt"))){

            People2 people = new People2("ADONIS");

            outputStream.writeObject(people);
            outputStream.flush();

            people = (People2) inputStream.readObject();

            System.out.println(people.name);  //虽然能得到对象，但是name属性并没有保存，因此为null
        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    static class People2 implements Serializable{
        private static final long serialVersionUID = 1234567;

        transient String name; //不希望某些属性参与到序列化中进行保存,使用transient

        public People2(String name){
            this.name = name;
        }
        //在一些JDK内部的源码中，也存在大量的transient关键字，使得某些属性不参与序列化，取消这些不必要保存的属性，可以节省数据空间占用以及减少序列化时间。
}

}
