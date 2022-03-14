package JavaSE.part3.DataStructure.HashTable;

public class Node {

    private String str;// 结点内的数据,可以是数值,也可以是一个对象;

    private int key;// 每个结点有一个key值用于hash表的取值;

    private Node next;// 这个结点的下一个结点索引;

    public Node(String str) {// 结点的构造函数;
        this.str = str;
        this.key = str.length();
    }

    public void setNext(Node node) {// 设置这个结点的下一个结点;
        this.next = node;
    }

    public int getKey() {// 返回key值;
        return key;
    }

    public String getStr() {// 返回字符串;
        return str;
    }

    public Node getNextNode() {// 返回下一个结点;
        return next;
    }

    public String getObject() {// 返回这个数据;
        return str;
    }
}
