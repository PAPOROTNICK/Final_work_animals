package animalregistry;

public class PackAnimal extends Animal {
    public PackAnimal(String name, int age) {
        super(name, age);
    }

    @Override
    public String getType() {
        return "Вьючное животное";
    }

    @Override
    public String getSpecificType() {
        return "Общее вьючное животное";
    }
}
