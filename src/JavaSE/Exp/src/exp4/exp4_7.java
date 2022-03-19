package exp4;

public class exp4_7 {
    public static void main(String[] args) {
        exp4_7_Complex c1=new exp4_7_Complex(1,1);
        exp4_7_Complex c2=new exp4_7_Complex(2,2);
        System.out.println(c1.get()+" + "+c2.get()+"="+c1.add(c2).get());
        System.out.println(c1.get()+"与"+c2.get()+"是否相等："+exp4_7_Complex.isEqual(c1, c2));
    }
}
