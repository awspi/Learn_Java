package JavaSE.part3.DataStructure.Queue;
//队列 实际上是循环队列（会浪费一个空间）
public class ArrayQueue<E> extends AbstractQueue<E>{
    //底层数组
    private Object[] arr=new Object[4];
    //队尾队首下标
    private int head=0,tail=0;
    //head为首元素，tail为末尾元素的下一个
    @Override
    public void offer(E e) {//入队
        int next=(tail+1)%arr.length;//怎么理解？
        if (next==head)return;//next==head队满
        arr[tail]=e;
        tail=next;
        //如果最后一个元素位置被使用后，要再存下一个元素，
        // 那么按循环队列的定义，应该是存到数组的开头，
        // 而对arr.length取余则可以使得下标从arr.length-1变为0，然后递增，达到循环的目的。

    }

    @Override
    public E poll() {
        E e= (E) arr[head];
        head=(head+1)%arr.length;
        return e;
    }
}
