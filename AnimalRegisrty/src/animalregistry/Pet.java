package animalregistry;

public class Pet extends Animal {
    public Pet(String name, int age) {
        super(name, age);
    }

    @Override
    public String getType() {
        return "Домашнее животное";
    }

    @Override
    public String getSpecificType() {
        return "Общее домашнее животное";
    }
}
