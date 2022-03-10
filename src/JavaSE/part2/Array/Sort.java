package JavaSE.part2.Array;
//冒泡 插入 选择
//参考https://visualgo.net/zh/sorting
import java.util.Arrays;
import java.util.Random;

public class Sort {
    public static void main(String[] args) {
       int[] arr=new int[10];
        for (int i=0;i<arr.length;i++){
            arr[i]=new Random().nextInt(100);
        }
        System.out.println(Arrays.toString(arr));
//        sort1(arr);
//        sort2(arr);
        sort3(arr);
        System.out.println(Arrays.toString(arr));
    }
    static  void sort1(int[] arr){//冒泡排序
            for (int j=0;j<arr.length-1;j++){
                boolean ok=true;//优化 如果提前完成排序就跳出
                for (int i=0;i<arr.length-j-1;i++){//length-1-j  -j是因为j后的已经排完了
                    if (arr[i]>arr[i+1]){
                        ok=false;
                        int temp=arr[i];
                        arr[i]=arr[i+1];
                        arr[i+1]=temp;
                    }
            }
                if (ok)break;

                System.out.println(Arrays.toString(arr));
        }
    }
    static void sort2(int[] arr){//插入排序
        for (int i=1;i<arr.length;i++){
            int temp=arr[i];
            int j=i-1;
            while (j>=0&&temp<arr[j]  ){
                arr[j+1]=arr[j];//后一个被前一个覆盖
                j--;
            }
            arr[j+1]=temp;//j+1
            System.out.println(Arrays.toString(arr));
        }
    }
    static void sort3(int[] arr){//选择排序
    for (int i=0;i<arr.length;i++){
        int min=arr[i];
        int pos=i;
        for (int j=i+1;j<arr.length;j++){
            if (arr[j]<min){
                min=arr[j];
                pos=j;
            }
        }
        arr[pos]=arr[i];
        arr[i]=min;
    }
    }
}
