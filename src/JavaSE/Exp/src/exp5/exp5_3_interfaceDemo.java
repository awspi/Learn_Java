package exp5;

public class exp5_3_interfaceDemo {
    public static void main(String args[]){
        exp5_3_Bus v1 = new exp5_3_Bus();
        exp5_3_Bike v2 = new exp5_3_Bike();
        //Bus
        System.out.println(v1.start(1));
        System.out.println(v1.stop(1));
        //Bike
        System.out.println(v2.start(1));
        System.out.println(v2.stop(1));

    }

}

