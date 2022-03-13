package JavaSE.part3.DataStructure.Stack;

//1.当要push的时候，相当于新new一个头结点，然后让新节点指向单链表的头结点。
// 以新节点作为单链表的头节点即可。
//2.当要pop的时候，只要将链表的头指针后移到它的next，将next作为新的头结点即可
public class LinkedStack<E> extends AbstractStack<E> {
    //头节点
    LinkedStack.Node<E> head=new LinkedStack.Node<>(null);
    private static class Node<E>{
        private E e;
        private LinkedStack.Node<E> next;
        public Node(E e){
            this.e=e;
        }
    }

    @Override
    public E pop() {
        Node ret=head;
        head=head.next;

        return (E)ret.e;
    }

    @Override
    public void push(E e) {
        Node<E> temp=new Node<>(e);
        temp.next=head;
        this.head=temp;

    }
    //todo
}
