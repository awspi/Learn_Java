package JavaSE.part3.DataStructure.Stack;
//FILO
public class ArrayStack<E> extends AbstractStack<E> {
    //底层数组
    private Object[] arr = new Object[20];
    //length
    private int size;//也相当于栈顶指针
    @Override
    public E pop() {//出栈
        return (E) arr[(size--)-1];//size-1为栈顶元素 取出后要size--
        //不需要清空，如果再push就直接覆盖
    }

    @Override
    public void push(E e) {//入栈
        //扩容
        if (size==arr.length){
            Object[] arr =new Object[this.arr.length+20];
            for (int i=0;i<this.arr.length;i++) arr[i]=this.arr[i];
            this.arr=arr;
        }
        //入栈
        arr[size]=e; //arr是底层数组
        size++;
    }
}


