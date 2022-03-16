package JavaSE.part2.Exp;

//0/1背包问题（回溯法、剪枝/动态规划优化）
//给定 n件物品，每一个物品的重量为 w[n]，每个物品的价值为 v[n]。
// 现挑选物品放入背包中，假定背包能承受的最大重量为 capacity，求装入物品的最大价值是多少?
public class Exp4 {
    static int[] w = {2, 3, 4, 5};
    static int[] v = {3, 4, 5, 6};
    static int capacity = 8;

    public static void main(String[] args) {
        System.out.println(fun1(0,0));
    }
    static int fun1(int index,int weight){//回溯法
        if(index>=4)return 0;
        if(capacity<weight+w[index])return 0;
        return Math.max(v[index]+fun1(index+1,weight+w[index]), fun1(index+1,weight));

    }
    static int fun2(){
        return  0;
    }
}
