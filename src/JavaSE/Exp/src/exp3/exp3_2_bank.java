package JavaSE.Exp.exp3;

import java.util.Scanner;

public class exp3_2_bank {
    private double balance;
    int id;
    Scanner reader = new Scanner(System.in);

    exp3_2_bank(double balance,int id){
        this.balance= balance;
        id=this.id;
    }

    void CheckBalance() {
        System.out.println("账户"+id);
        System.out.println("余额："+balance);
    }

    void DrawMoney() {
        double x;
        System.out.print("请输入取款金额：");
        x=reader.nextDouble();
        if((balance-x)<=0) {
            System.out.println("余额不足！");
        }
        else {
            System.out.println("取款成功！");
            balance=balance-x;
        }
        CheckBalance();
    }

    void Deposit() {
        double x;
        System.out.print("请输入存款金额：");
        x=reader.nextDouble();
        balance=balance+x;
        CheckBalance();
    }
}
