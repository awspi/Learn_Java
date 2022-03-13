package JavaSE.part3.DataStructure.List.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> list=new LinkedList<>();
        list.add("A",0);
        list.add("B",0);
        list.remove(0);
        System.out.println(list.get(0));
    }
}
