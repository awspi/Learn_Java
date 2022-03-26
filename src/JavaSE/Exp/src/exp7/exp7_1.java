package exp7;

import java.io.File;
import java.io.IOException;

public class exp7_1 {
    public static void main(String[] args) throws IOException {
        File file =new File("src/exp7/201911020101.txt");
        File pFile= file.getParentFile();
        if(!pFile.exists()){
            System.out.println("文件夹不存在，新建一个");
            file.mkdirs();//建立文件夹 mkdirs可以多级
        }
        if(!file.exists()){
            System.out.println("文件不存在，新建一个");
            file.createNewFile();//创建新文件
        }

        System.out.println(

                "文件名："+file.getName()+
                "\n相对路径："+file.getPath()+
                "\n文件大小："+file.getTotalSpace()

        );



    }
}
