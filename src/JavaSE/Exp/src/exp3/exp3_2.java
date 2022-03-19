package JavaSE.Exp.exp3;

import java.util.Scanner;

public class exp3_2 {
    public static void main(String[] args) {
        exp3_2_bank account = new exp3_2_bank(999,1);
            Scanner reader = new Scanner(System.in);
            int op=-1;
            while(op!=0) {
                System.out.println("1：存款");
                System.out.println("2：查询");
                System.out.println("3：取款");
                System.out.println("please input：");
                op=reader.nextInt();

                switch(op) {
                    case 1:account.Deposit();break;
                    case 2:account.CheckBalance();break;
                    case 3:account.DrawMoney();break;
                }

    }
    }
}