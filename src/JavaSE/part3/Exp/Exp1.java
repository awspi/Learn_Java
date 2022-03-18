package JavaSE.part3.Exp;
//反转链表
//1 <- 3 <- 5 <- 7 <- 9  转换为 1 <- 3 <- 5 <- 7 <- 9
//现在有一个单链表，尝试将其所有节点倒序排列
public class Exp1 {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(5);
        head.next.next.next = new Node(7);
        head.next.next.next.next = new Node(9);

        head = reverse(head);

        while (head != null){
            System.out.print(head.value+" ");
            head = head.next;
        }
    }

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node reverse(Node head) {
        if (head.next==null){return head;}
        Node newHead=reverse(head.next);//最后一个
        Node next=head.next;
        //1 <- 3 <- 5head <- 7head.next <- 9
        next.next=head;
        head.next=null;
        return newHead;
    }
}
