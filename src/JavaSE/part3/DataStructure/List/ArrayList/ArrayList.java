package JavaSE.part3.DataStructure.List.ArrayList;

import JavaSE.part3.DataStructure.List.AbstractList;

public class ArrayList<E> extends AbstractList<E> {
    //底层数组Object 是所有的父类可以兼容number string等
    private Object[] arr=new Object[1];
    //length
    private int size=0;

    @Override
    public int size() {
        return size;
    }


    @Override
    public void add(E obj, int index) {
        //step0 安全检查
        if (index>size)throw new IllegalArgumentException("非法操作位置");
        //step1检查扩容
        if (size==arr.length){
            //新生成个arr 长度+10 元素逐个替换原有的
            Object[] arr=new Object[this.arr.length+10];
            for (int i=0;i<this.arr.length;i++){
                arr[i]=this.arr[i];

            }
            this.arr=arr;
        }
        //Step2空出位置
        int i=size-1;//下标
        while (i>=index){//不是i>=index-1
            arr[i+1]=arr[i];
            i--;
        }
        //添加元素
        arr[index]=obj;
        size++;
    }

    @Override
    public E remove(int index) {
        //step0 安全检查
        if (index>size-1)throw new IllegalArgumentException("非法删除位置");
        E e= (E) arr[index];
        //后一项前移
        while (index<size-1){
            arr[index]=arr[index+1];
            index++;
        }
        //这里的remove 不考虑删掉元素后arr[size-1]的情况
        //也就是说删除后 size--；无论arr[size-1]有没有内容都不影响add();
        //比如删除最后一项arr【size-1】， 并没有对arr【size-1】进行操作，直接就size--；
        size--;
        return e;
    }

    @Override
    public E get(int index) {
        if (index>size-1) throw new IndexOutOfBoundsException("无法访问下标位置");
        E e=(E)arr[index];
        return e;
    }


}
