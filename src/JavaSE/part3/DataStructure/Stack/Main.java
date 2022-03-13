package JavaSE.part3.DataStructure.Stack;

public class Main {
    public static void main(String[] args) {
        ArrayStack<String>stack=new ArrayStack<>();
        stack.push("A");
        stack.push("B");
        stack.push("D");
        System.out.println("debug");
        stack.pop();
        stack.push("C");
        System.out.println("debug");
    }
}
