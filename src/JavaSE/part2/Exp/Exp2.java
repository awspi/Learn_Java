package JavaSE.part2.Exp;
//二分搜索（搜索算法）
//现在有一个 有序 数组（从小到大，数组长度 0 < n < 1000000）如何快速寻找我们想要的数在哪个位置，如果存在请返回下标，不存在返回-1即可。
public class Exp2 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 5, 6, 7, 10, 12, 14, 20, 22, 26};   //测试用例
        System.out.println(test(arr, 4));
    }
    private static int test(int[] arr, int target){
        int index=-1;
        int start=0,end=arr.length-1;
        while (start<=end){
            int mid=(start+end+1)/2;
            if (arr[mid]==target) return mid;
            if (arr[mid]>target) end=mid-1;
            if (arr[mid]<target) start=mid+1;
        }
        return index;
    }
}
