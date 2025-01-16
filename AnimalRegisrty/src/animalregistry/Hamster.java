package animalregistry;

public class Hamster extends Pet {
    public Hamster(String name, int age) {
        super(name, age);
    }

    @Override
    public String getSpecificType() {
        return "Хомяк";
    }
}
