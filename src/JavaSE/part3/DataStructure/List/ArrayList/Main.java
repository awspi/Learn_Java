package JavaSE.part3.DataStructure.List.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<>();
        list.add("A",0);
        list.add("B",0);
        list.remove(0);
        System.out.println(list.get(0));
    }
}
