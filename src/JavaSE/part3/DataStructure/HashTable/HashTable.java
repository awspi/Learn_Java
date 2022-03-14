package JavaSE.part3.DataStructure.HashTable;
public class HashTable {

    private static NodeList[] array;// 静态列表;

    private int length;// 数组长度;

    public HashTable(int length) {
        this.length = length;
        array = new NodeList[length];// 实例化一个数组对象,内置元素是NodeList链表;
        for (int i = 0; i < length; i++) {
            array[i] = new NodeList();// 再一个个给链表实例化对象,否则会空指针报错;
        }
    }

    public int getLength() {// 返回数组长度;
        return length;
    }

    public NodeList getArray(int i) {// 返回第i个链表;
        return array[i];
    }

    public void addStr(Node node) {
        int key = node.getKey();// 获取key键;
        int index = key % length;// 通过key值获取散列坐标;
        array[index].addNode(node);// 放入;
    }
}