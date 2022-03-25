package exp5;

public class exp5_2 {
    public static void main(String args[]) {
        training d = new training();
        System.out.println(d.d.dance());
        System.out.println(d.d.cry());
    }
    static class training {
        dolphin d;
        training() {
            d = new dolphin();
        }
        class dolphin {
            String dance() {
                return "dance";
            }
            String cry() {
                return "huhu~~";
            }

        }
    }
}


