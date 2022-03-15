package JavaSE.part3.DataStructure.HashTable;
//todo

//https://zhuanlan.zhihu.com/p/30284593
import java.util.Scanner;

//public class Main {
//    public static void main(String[] args) {
//        HashTable ht=new HashTable(16);
//        for (int i=0;i<100;i++){
//            ht.addStr(new Node(i+""));
//        }
//        int i=0;
//        while (ht.getArray(i).getRoot() != null){
//            System.out.print("index:"+i);
//            ht.getArray(i).showList();
//        }
//    }
//    }
//
public class Main {

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis(); // 获取开始时间;
        Scanner sc = new Scanner(System.in);// 输入流;
        System.out.println("输入你说希望的哈希表长度:");
        int len = sc.nextInt();
        HashTable table = new HashTable(len);// 创建一个长度为100的哈希表;
        System.out.println("输入要输入元素的个数:");
        int n = sc.nextInt();// 输入要加入哈希表的元素个数;
        for (int i = 0; i < n; i++) { // 散列进哈希表;
            String str = sc.next(); // 字符串对象;
            Node node = new Node(str);// 构建结点;
            table.addStr(node);// 放入结点;
        }

        for (int i = 0; i < len; i++) {// 展示一下这些字符串都存哪里了;
            System.out.print("第" + (i + 1) + "个空格里有: ");
            if (table.getArray(i).getRoot() == null) {
                System.out.println("(empty)");
            } else {
                table.getArray(i).showList();
            }
        }

        long endTime = System.currentTimeMillis(); // 获取结束时间
    }
    }