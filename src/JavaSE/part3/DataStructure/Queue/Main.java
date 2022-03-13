package JavaSE.part3.DataStructure.Queue;

public class Main {
    public static void main(String[] args) {
        ArrayQueue<String> queue=new ArrayQueue<>();
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.poll();
        queue.offer("d");
        queue.offer("e");
        System.out.println("debug");

    }
}
