package animalregistry;

public class Camel extends PackAnimal {
    public Camel(String name, int age) {
        super(name, age);
    }

    @Override
    public String getSpecificType() {
        return "Верблюд";
    }
}
