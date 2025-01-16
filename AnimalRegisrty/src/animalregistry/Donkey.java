package animalregistry;

public class Donkey extends PackAnimal {
    public Donkey(String name, int age) {
        super(name, age);
    }

    @Override
    public String getSpecificType() {
        return "Осел";
    }
}
