package JavaSE.part3.DataStructure.Tree;

public class TreeNode<E> {
    public E e;   //当前结点数据
    public TreeNode<E> left;   //左子树
    public TreeNode<E> right;   //右子树
    public TreeNode (E e){
        this.e=e;
    }
}