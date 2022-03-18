package JavaSE.part4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

//File类专门用于表示一个文件或文件夹，只不过它只是代表这个文件，但并不是这个文件本身。
// 通过File对象，可以更好地管理和操作硬盘上的文件。
public class File_ {
    public static void main(String[] args) {
        test();
        test2();
        test3();
    }
    public static void test(){
        File file = new File("src/JavaSE/part4/test.txt");   //直接创建文件对象，可以是相对路径，也可以是绝对路径
        System.out.println(file.exists());   //此文件是否存在
        System.out.println(file.length());   //获取文件的大小
        System.out.println(file.isDirectory());   //是否为一个文件夹
        System.out.println(file.canRead());   //是否可读
        System.out.println(file.canWrite());   //是否可写
        System.out.println(file.canExecute());   //是否可执行
    }
    public static void test2(){
        File file = new File("src/JavaSE");
//        file.mkdirs("aaa/bbb/cccs")//递归创建文件夹
        System.out.println(Arrays.toString(file.list()));   //快速获取文件夹下的文件名称列表
        for (File f : file.listFiles()){   //所有子文件的File对象
            System.out.println(f.getAbsolutePath());   //获取文件的绝对路径
        }
    }

    //拷贝文件夹下的所有文件到另一个文件夹
    public static void test3(){
        File file=new File(".idea");
        File target=new File("src/JavaSE/part4/new");
        target.mkdir();//创建目录
        for (File f:file.listFiles()){
            try (FileInputStream inputStream=new FileInputStream(f);
                 FileOutputStream outputStream=new FileOutputStream(target.getPath()+"/"+f.getName())){// +"/"+
                byte[] bytes=new byte[20];
                int tmp;
                while ((tmp=inputStream.read(bytes))!=-1){
                    outputStream.write(bytes,0,tmp);
                }
                outputStream.flush();

            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

}
