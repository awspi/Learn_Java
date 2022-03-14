package JavaSE.part3.DataStructure.HashTable;

public class NodeList {

    private Node root = null;// 初始结点是一个空的结点,root是一切的开始;

    // 添加结点的方法;
    public void addNode(Node node) {
        // 首先判断root是不是为空;
        if (root == null) {// 如果链表为空,直接把node的值赋予root;
            root = node;
        } else {
            // 插到root后面;
            node.setNext(root);
            root = node;
        }
    }

    public Node getRoot() {// 获得根结点;
        return root;
    }

    public void showList() {// 从根结点出发遍历输出;
        Node temp = root;
        while (temp != null) {
            System.out.print(temp.getObject().toString() + " ");
            temp = temp.getNextNode();
        }
        System.out.println();
    }
}