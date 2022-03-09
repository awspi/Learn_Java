package JavaSE.part1;
//九九乘法表
public class exp1 {
    public static void main(String[] args) {
        for (int i=1;i<=9;i++){
            for(int j=1;j<=9;j++){
                if (j>i) break;
                System.out.print(j+"x"+i+"="+j*i+" ");
            }
            System.out.println();
        }
    }
}
