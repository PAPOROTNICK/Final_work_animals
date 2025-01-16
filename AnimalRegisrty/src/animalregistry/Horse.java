package animalregistry;

public class Horse extends PackAnimal {
    public Horse(String name, int age) {
        super(name, age);
    }

    @Override
    public String getSpecificType() {
        return "Лошадь";
    }
}
