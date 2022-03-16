package JavaSE.Exp.exp3;

public class exp3_3_Cart {
    private int sum;
    private double totalPrice;
    private int max=30;//上限
    private exp3_3_Goods[] goods;
    exp3_3_Cart(){
        this.goods=new exp3_3_Goods[max];
    }
    public void print(){
        System.out.println("购物车：");
        for (exp3_3_Goods good : goods){
            if (good==null)break;
            System.out.println(good.getName()+" "+good.getPrice());
        }
        System.out.println("需要支付："+totalPrice);
    }
    public void add(exp3_3_Goods goods){
        this.goods[sum++]=goods;
        totalPrice+=goods.getPrice();
    }


}
