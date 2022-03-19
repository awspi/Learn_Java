package exp4;

public class exp4_7_Complex {
    private double m;//实部
    private double n;//虚部

    public exp4_7_Complex(double m, double n) {
        this.m = m;
        this.n = n;
    }
    public String get(){
        return m+"+"+n+"i";
    }
    public exp4_7_Complex add(exp4_7_Complex c){
        return new exp4_7_Complex(c.m+m,c.n+n);
    }
    public exp4_7_Complex minus(exp4_7_Complex c){
        return new exp4_7_Complex(c.m-m,c.n-n);
    }
    public exp4_7_Complex multiply(exp4_7_Complex c){
        return new exp4_7_Complex(c.m*m,c.n*n);
    }
    public static boolean isEqual(exp4_7_Complex c1,exp4_7_Complex c2){
        return c1.m==c2.m||c1.n==c2.n;
    }

}
