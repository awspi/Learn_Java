package JavaSE.part1;
//水仙花数
public class exp2 {
    public static void main(String[] args) {
        for(int i=1;i<1000;i++){
            int sum = 0;
            int i1 = i;
            while (i1!=0){
                int n=i1%10;
                i1/=10;
                sum+=n*n*n;
            }
            if (sum==i){
                System.out.println(i);
            }
        }
    }
}
