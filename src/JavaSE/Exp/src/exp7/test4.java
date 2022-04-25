package JavaSE.exp.src.exp7;

import java.io.*;

public class test4 {
    public static void byteIO() throws IOException{
        try {//write
            File f=new File("src/JavaSE/exp/src/exp7/zzz.txt");
            FileOutputStream out=new FileOutputStream(f,true);
            byte[] a="pith".getBytes();
            out.write(a,0,a.length);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {//read
            File f=new File("src/JavaSE/exp/src/exp7/zzz.txt");
            FileInputStream in =new FileInputStream(f);
            byte[] s=new byte[4];
            int len=0;
            while((len=in.read(s))!=-1){
                System.out.println(new String(s,0,len));
            }
            in.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void charIO(){
    try {
        File f_in=new File("src/JavaSE/exp/src/exp7/zzz.txt");
        File f_out=new File("src/JavaSE/exp/src/exp7/zzzz.txt");
        FileReader in =new FileReader(f_in);
        FileWriter out =new FileWriter(f_out);
        char[] c=new char[4];

        int len=0;
        while ((len=in.read(c,0,c.length))!=-1){
            System.out.println(new String(c,0,len));
            out.write(c,0,len);
        }
        out.flush();
        out.close();
    }catch (IOException e){
        e.printStackTrace();
    }
    }

    public static void main(String[] args) throws IOException{
        byteIO();
        charIO();
    }
}
