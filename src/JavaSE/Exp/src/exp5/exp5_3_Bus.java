package exp5;

public class exp5_3_Bus implements exp5_3_Vehicle{

    @Override
    public String start(int n) {
        return "Bus Start";
    }

    @Override
    public String stop(int n) {
        return "Bus Stop";
    }
}
