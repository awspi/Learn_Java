package exp7;

import java.io.*;

public class exp7_3 {
    //缓冲字符流
    public static void handle(){//JDK1.7新增了try-with-resource语法，用于简化
        ////直接在try()中定义要在完成之后释放的资源,也可以多个
        try (BufferedReader reader = new BufferedReader(new FileReader("src/exp7/row.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("src/exp7/output.txt"))){
            System.out.println(reader.readLine());//使用和reader也是一样的，支持按行读取
            int i=1;
            String str;
            while ((str = reader.readLine()) != null){
                System.out.println(str);
                writer.write(i+"."+str+"\n");
                i++;
            }
            writer.flush();   //清空缓冲区
        }catch (IOException e) {
            e.toString();
        }
    }

    public static void main(String[] args) {
        handle();
    }

}
