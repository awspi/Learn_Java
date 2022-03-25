package exp6;

public class exp6_4 {

    public static void main(String[] args) {
        exp6_4_Calendar c1=new exp6_4_Calendar(2022,3,22);
        exp6_4_Calendar c2=new exp6_4_Calendar(2022,3,26);
        exp6_4_Calendar.IntervalTime(c1,c2);
        exp6_4_Calendar c3=new exp6_4_Calendar(2023,2,22);
        exp6_4_Calendar.IntervalTime(c3,c2);
    }
}
