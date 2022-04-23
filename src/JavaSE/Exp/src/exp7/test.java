package JavaSE.exp.src.exp7;

import java.io.*;

public class test {
    public static void main(String[] args) {
        int n=1;
        File f =new File("hello.txt");
        byte[] a="abcdefg".getBytes();
        try{
            FileOutputStream out =new FileOutputStream(f);
            out.write(a);
            out.close();
            FileInputStream in =new FileInputStream(f);
            byte[] tom =new byte[4];
            int m=in.read(tom,0,4);
            System.out.println(m);
            String s= new String(tom,0,4);
            System.out.println(s);
            m=in.read(tom,0,4);//efg
            System.out.println(m);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
