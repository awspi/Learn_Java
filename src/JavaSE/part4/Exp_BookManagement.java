package JavaSE.part4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//## Java I/O编程实战
//### 图书管理系统
//要求实现一个图书管理系统（控制台），支持以下功能：保存书籍信息（要求持久化），查询、添加、删除、修改书籍信息。
public class Exp_BookManagement {
    private static  List<Book> LIST=new ArrayList<>();


    public static void main(String[] args) {
        readData();
        Scanner scanner=new Scanner(System.in);
        while (true){
            System.out.println(
                    "   ___  ____  ____  __ __\n" +
                    "  / _ )/ __ \\/ __ \\/ //_/\n" +
                    " / _  / /_/ / /_/ / ,<   \n" +
                    "/____/\\____/\\____/_/|_|  \n" +
                    " \t————Management system");
            System.out.println(
                    "\t1.插入信息\n"+
                    "\t2.修改信息\n"+
                    "\t3.查询图书列表\n"+
                    "\t4.删除图书\n" +
                            "\t(按其他任意键退出)");
            String str=scanner.nextLine();

            switch (str){
                case "1":
                    insertBook(scanner);
                    break;
                case "2":
                    modifyBook(scanner);
                    break;
                case "3":
                    showBooks();
                    break;
                case "4":
                    deleteBook(scanner);
                    break;
                default:
                    scanner.close();
                    savaData();
                    return;
            }
        }

    }
    private  static void readData(){
        File file=new File("src/JavaSE/part4/bookData");
        if(file.exists()){

        }
        try(ObjectInputStream inputStream=new ObjectInputStream(new FileInputStream("src/JavaSE/part4/bookData"))){
            LIST=(List<Book>) inputStream.readObject();
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    private static void savaData(){
        try(ObjectOutputStream outputStream=new ObjectOutputStream(new FileOutputStream("src/JavaSE/part4/bookData"))) {
            outputStream.writeObject(LIST);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void modifyBook(Scanner scanner) {
        showBooks();
        int index=scanner.nextInt();
        scanner.nextLine();
        if(index>=LIST.size()) System.out.println("wrong index");
        else {
            LIST.get(index) //链式
                    .name(scanner.nextLine())
                    .author(scanner.nextLine())
                    .price(scanner.nextDouble());
        }
        scanner.nextLine();

    }
    private  static void deleteBook(Scanner scanner){
//        int i=0;
//        System.out.println("!1113");
//        for(Book book:LIST){
//            System.out.println((i++)+"."+book.toString());
//        }
        showBooks();
        int index=scanner.nextInt();
        if(index>=LIST.size()) System.out.println("wrong index");
        else LIST.remove(index);
        scanner.nextLine();
    }
    private static void showBooks (){
//        LIST.forEach(System.out::println);//foreach  println函数会调用qtostring方法
        int i=0;
        for(Book book:LIST){
            System.out.println((i++)+"."+book);
        }


    }
    private  static void insertBook(Scanner scanner){//todo 异常处理 可能报错

        LIST.add(new Book() //链式
                .name(scanner.nextLine())
                .author(scanner.nextLine())
                .price(scanner.nextDouble()));
        scanner.nextLine();//输入完换行符没被吸收

    }
    private static class Book implements Serializable{//序列化接口
        String name;
        String author;
        double price;
        //链式调用
        public Book name(String name){
            this.name=name;
            return this;
        }
        public Book author(String author){
            this.author=author;
            return this;
        }
        public Book price(double price){
            this.price=price;
            return this;
        }

        @Override //重写toString方法
        public String toString() {
            return "Book{" +
                    "name='" + name + '\'' +
                    ", author='" + author + '\'' +
                    ", price=" + price +
                    '}';
        }
    }
}
