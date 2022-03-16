package JavaSE.part2.Exp;

import java.util.Arrays;

//快速排序（排序算法、递归分治）
//https://blog.csdn.net/nrsc272420199/article/details/82587933
public class Exp3 {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 1, 6, 7, 12, 11, 17, 3, 22, 15};   //测试用例
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    static void quickSort(int[] arr,int start,int end){
        if (start>=end)return;
        int k=arr[start],low=start,high=end;
        while (low<high){
            while (low<high&&k<=arr[high]) high--;
            arr[low]=arr[high];
            while (low<high&&k>=arr[low]) low++;
            arr[high]=arr[low];
        }
        arr[high]=k;
        quickSort(arr,start,high-1);
        quickSort(arr,high+1,end);

    }
}
