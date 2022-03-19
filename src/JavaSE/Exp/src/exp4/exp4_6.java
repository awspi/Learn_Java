package exp4;

public class exp4_6 {//StudentDemo

    public static void main(String[] args) {
        exp4_6_Undergraduate s1=new exp4_6_Undergraduate("张三",99,88,77);
        exp4_6_Undergraduate s2=new exp4_6_Undergraduate("李四",66,77,70);
        exp4_6_Undergraduate s3=new exp4_6_Undergraduate("王五",54,56,61);

        exp4_6_Undergraduate s4=new exp4_6_Undergraduate("小明",80,81,89);
        exp4_6_Undergraduate s5=new exp4_6_Undergraduate("小王",71,69,88);
        exp4_6_Undergraduate s6=new exp4_6_Undergraduate("小张",98,99,90);

        System.out.println(s1.getName()+"\t总分：\t" + s1.getTotal()+"\t是否可以拿到学位：\t"+s1.check());
        System.out.println(s2.getName()+"\t总分：\t" + s2.getTotal()+"\t是否可以拿到学位：\t"+s2.check());
        System.out.println(s3.getName()+"\t总分：\t" + s3.getTotal()+"\t是否可以拿到学位：\t"+s3.check());
        System.out.println(s4.getName()+"\t总分：\t" + s4.getTotal()+"\t是否可以拿到学位：\t"+s4.check());
        System.out.println(s5.getName()+"\t总分：\t" + s5.getTotal()+"\t是否可以拿到学位：\t"+s5.check());
        System.out.println(s6.getName()+"\t总分：\t" + s6.getTotal()+"\t是否可以拿到学位：\t"+s6.check());
    }
}
