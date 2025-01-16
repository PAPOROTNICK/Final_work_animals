package animalregistry;

public class Cat extends Pet {
    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public String getSpecificType() {
        return "Кошка";
    }
}
