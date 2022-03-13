package JavaSE.part3.DataStructure.List.LinkedList;

import JavaSE.part3.DataStructure.List.AbstractList;
//数据分散的存储在物理空间中，通过一根线保存着它们之间的逻辑关系，这种存储结构称为链式存储结构
//实际上，就是每一个结点存放一个元素和一个指向下一个结点的引用
public class LinkedList<E> extends AbstractList<E> {
    //头节点->首节点(head.next)->2nd节点（1st.next->3rd->...;
    //头节点
    Node<E> head=new Node<E>(null);
    private int size;
    private static class Node<E>{
        private E e;
        private Node<E> next;
        public Node(E e){
            this.e=e;
        }
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(E e, int index) {
        if (index>size)throw new IllegalArgumentException("非法操作位置");
        //head->e1->e2->e3
        //head->e1->e->e2->e3
        //找到位置
        Node<E> node=head;
        for (int i=0;i<index;i++){
            node=node.next;
        }
        Node<E> temp=node.next;
        node.next=new Node<E>(e);
        node.next.next=temp;
        //想一下这个node的位置是谁的位置，怎么来的？
        //链表生成后，自带头节点（没有数据，只有一个next是对首节点对引用）
        //add 插入到index位置，使用for (int i=0;i<index;i++)
        // i<index i最终位置首index(目标位置)的前一个节点
        //怎么实现插入？
        //记录原先的next所指  Node<E> temp=node.next;
        //node.next=new Node<E>(e); 前一个节点的next，new出要插入的节点，就可以实现在指定位置插入
        //插入的节点.next重新指向记录原先的next所指，重新把链表连起来
        size++;
    }

    @Override
    public E remove(int index) {
        //找到位置
        Node<E> node=head;
        for (int i=0;i<index;i++){
            node=node.next;
        }
        Node<E> ret=node.next;
        node.next=node.next.next;
        return ret.e;
    }

    @Override
    public E get(int index) {
        Node<E> node=head;
        for (int i=0;i<index;i++){
            node=node.next;
        }
        Node<E> ret=node.next;
        return ret.e;
    }
}
