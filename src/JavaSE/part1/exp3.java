package JavaSE.part1;
//青蛙跳台阶
public class exp3 {
    public static void main(String[] args) {
        int n=10;
        int[] arr=new int[n];
        arr[0]=1;
        arr[1]=2;
        for (int i=2;i<n;i++){
            arr[i]=arr[i-1]+arr[i-2];
            System.out.println((i+1)+"阶台阶有"+arr[i]+"种跳法");
        }
    }
}
