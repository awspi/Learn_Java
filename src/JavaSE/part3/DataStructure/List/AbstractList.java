package JavaSE.part3.DataStructure.List;
//以数组为底层，编写以下抽象类的具体实现
/**
 * 线性表抽象类
 * @param <E> 存储的元素(Element)类型
 */
public abstract class AbstractList<E> {
    /**
     * 获取表的长度
     * @return 顺序表的长度
     */
    public abstract int size();

    /**
     * 添加一个元素
     * @param e 元素
     * @param index 要添加的位置(索引)
     */
    public abstract void add(E e, int index);

    /**
     * 移除指定位置的元素
     * @param index 位置
     * @return 移除的元素
     */
    public abstract E remove(int index);

    /**
     * 获取指定位置的元素
     * @param index 位置
     * @return 元素
     */
    public abstract E get(int index);
}