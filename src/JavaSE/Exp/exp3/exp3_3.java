package JavaSE.Exp.exp3;

public class exp3_3 {
    public static void main(String[] args) {
        exp3_3_Goods good;//Goods对象，为接口回调做准备
        exp3_3_Cart cart = new exp3_3_Cart();
        cart.add(new exp3_3_Goods("可乐",3));
        cart.add(new exp3_3_Goods("芬达",3));
        cart.add(new exp3_3_Goods("薯片",7));
        cart.add(new exp3_3_Goods("方便面",5));
        cart.print();
    }
}
