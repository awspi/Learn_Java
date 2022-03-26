package exp7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class exp7_2 {
    public static void copyFile(){
        File file=new File("src/exp7/source.txt");
        File target=new File("src/exp7/backup.txt");

            try (FileInputStream inputStream=new FileInputStream(file);
                 FileOutputStream outputStream=new FileOutputStream(target.getPath())){
                byte[] bytes=new byte[20];
                int tmp;
                while ((tmp=inputStream.read(bytes))!=-1){
                    outputStream.write(bytes,0,tmp);
                }
                outputStream.flush();
                System.out.println("文件复制完成");
            }catch (IOException e){
                e.toString();
            }
    }

    public static void main(String[] args) {
        copyFile();
    }

}
