package exp4;

public class exp4_6_Undergraduate extends exp4_6_Student{
    exp4_6_Undergraduate(String name, int s1, int s2, int s3) {
        super(name, s1, s2, s3);
    }
    public boolean check(){
        return getTotal()>80;
    }
}
