package exp4;

public class exp4_4_Cat extends exp4_4_Animal {
    @Override
    void cry() {
        System.out.println("喵喵");
    }

    @Override
    String getAnimalName() {
        return "Cat";
    }
}
