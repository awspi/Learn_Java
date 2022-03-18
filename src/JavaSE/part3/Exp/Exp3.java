package JavaSE.part3.Exp;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

//### 实现计算器  双栈
//实现一个计算器，要求输入一个计算公式（含加减乘除运算符，没有负数但是有小数），得到结果
//比如输入：1+4*3/1.321，得到结果为：2.2
public class Exp3 {
    private static Deque<Character> opr=new LinkedList<>();//符号
    private static Deque<Double> number=new LinkedList<>();//数字
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String formula=scanner.nextLine();

        char[] str=formula.toCharArray();
        int i=0;
        while(i<str.length){
            char c=str[i];
            if(isOpr(c)){
                Character peek=opr.peek();//peek只引用最上一个元素 不出栈
                while(peek!=null&&isHigherPro(peek,c)){
                    cal();
                    peek=opr.peek();//cal后更新
                }
                opr.push(c);
                i++;
            }else{
                //考虑不是个位数
                double num=0;
                //考虑小数 1.23
                double num2=0;
                boolean flag=false;
                int times=1;

                while (i<=str.length-1&&!isOpr(str[i])){
                    if (str[i]=='.'){
                        flag=true;
                    }else {
                        if (flag){
                            double val=(str[i]-'0');
                            for (int j=0;j<times;j++) val/=10.0;
                            times++;
                            num2+=val;
                        }else {
                            num=num*10+(str[i]-'0');// - ascii码
                        }
                    }
                    i++;
                }

                number.push(num+num2);

            }
        }
        while (!opr.isEmpty()) cal();
        System.out.println(number.peek());
    }
    public static boolean isHigherPro(char peek,char c){
        return (peek=='*'||peek=='/')||(c=='+'||c=='-');
    }
    public static boolean isOpr(char c){
        return c=='+'||c=='-'||c=='*'||c=='/';
    }
    public static void cal(){
        double a=number.pop();//后一个
        double b=number.pop();//前一个
        char c=opr.pop();//符号
        switch (c){
            case '+':
                number.push(a+b);
                break;
            case '-':
                number.push(a-b);
                break;
            case '*':
                number.push(a*b);
                break;
            case '/':
                number.push(a/b);
                break;
        }
    }

}
