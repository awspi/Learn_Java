package JavaSE.part3.DataStructure.Tree;

public class Main {
    public static void main(String[] args) {
        TreeNode<String> root=new TreeNode<>("A");
        root.left=new TreeNode<>("B");
        root.right=new TreeNode<>("E");
        root.right.right=new TreeNode<>("F");
        root.left.left=new TreeNode<>("C");
        root.left.right=new TreeNode<>("D");
        System.out.println("debug");
        test(root);
    }
    public static void test(TreeNode node){//先序遍历  中 左 右
        if (node==null)return;
        System.out.print(node.e+" ");
        test(node.left);
        test(node.right);
    }
    public static void test2(TreeNode node){//后序遍历 左 右 中
        if (node==null)return;
        test(node.left);
        test(node.right);
        System.out.print(node.e+" ");
    }
    public static void test3(TreeNode node){//中序遍历 左 中 右
        if (node==null)return;
        test(node.left);
        System.out.print(node.e+" ");
        test(node.right);
    }
}
