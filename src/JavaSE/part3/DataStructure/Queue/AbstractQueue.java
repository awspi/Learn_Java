package JavaSE.part3.DataStructure.Queue;

/**
 *
 * @param <E>
 */
public abstract class AbstractQueue<E> {

    /**
     * 进队操作
     * @param e 元素
     */
    public abstract void offer(E e);

    /**
     * 出队操作
     * @return 元素
     */
    public abstract E poll();
}