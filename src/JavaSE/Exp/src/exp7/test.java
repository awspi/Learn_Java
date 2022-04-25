package JavaSE.exp.src.exp7;

public class test {
    test(){

    }
    void nmsl(){

    }
    private int a;
    class A{
        int x;
        A(int x){
            this.x=x;
        }
    }
    class B extends A{
        B(int x){
            super(x);
        }
    }
    public static void main(String[] args) {
        test a=new test();
        a.nmsl();
//        int n=1;
//        File f =new File("hello.txt");
//        byte[] a="abcdefg".getBytes();
//        try{
//            FileOutputStream out =new FileOutputStream(f);
//            out.write(a);
//            out.close();
//            FileInputStream in =new FileInputStream(f);
//            byte[] tom =new byte[4];
//            int m=in.read(tom,0,4);
//            System.out.println(m);
//            String s= new String(tom,0,4);
//            System.out.println(s);
//            m=in.read(tom,0,4);//efg
//            System.out.println(m);
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
////        }
//        double a=12.4;
//        a++;
//        System.out.println(a);
//        int c=(int)a/2;
//        System.out.println(c);
//        System.out.println(a);

    }
}
