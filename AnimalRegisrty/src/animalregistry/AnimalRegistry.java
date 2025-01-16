package animalregistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnimalRegistry {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Animal> animals = new ArrayList<>();

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            System.out.println("\nМеню реестра животных:");
            System.out.println("1. Добавить новое животное");
            System.out.println("2. Определить животное в правильный класс");
            System.out.println("3. Показать список животных");
            System.out.println("4. Обучить животное");
            System.out.println("5. Показать команды животного");
            System.out.println("6. Выход");
            System.out.print("Выберите опцию: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Потребление символа новой строки

            switch (choice) {
                case 1:
                    try (Counter counter = new Counter()) {
                        counter.markUsedInTry();
                        addAnimal(counter);
                        System.out.println("Добавлено животных: " + counter.getCount());
                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    break;
                case 2:
                    assignAnimalToClass();
                    break;
                case 3:
                    showAnimals();
                    break;
                case 4:
                    trainAnimal();
                    break;
                case 5:
                    showAnimalCommands();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте ещё раз.");
            }
        }
    }

    private static void addAnimal(Counter counter) {
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        System.out.print("Введите возраст: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        if (name.isEmpty() || age <= 0) {
            System.out.println("Все поля должны быть заполнены корректно.");
            return;
        }

        animals.add(new Pet(name, age));
        counter.add();
        System.out.println("Животное успешно добавлено.");
    }

    private static void assignAnimalToClass() {
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();

        Animal animal = animals.stream().filter(a -> a.getName().equalsIgnoreCase(name)).findFirst().orElse(null);

        if (animal == null) {
            System.out.println("Животное не найдено.");
            return;
        }

        System.out.print("Введите тип животного (Собака, Кошка, Хомяк, Лошадь, Верблюд, Осел): ");
        String type = scanner.nextLine();

        Animal newAnimal = switch (type.toLowerCase()) {
            case "собака" -> new Dog(animal.getName(), animal.getAge());
            case "кошка" -> new Cat(animal.getName(), animal.getAge());
            case "хомяк" -> new Hamster(animal.getName(), animal.getAge());
            case "лошадь" -> new Horse(animal.getName(), animal.getAge());
            case "верблюд" -> new Camel(animal.getName(), animal.getAge());
            case "осел" -> new Donkey(animal.getName(), animal.getAge());
            default -> null;
        };

        if (newAnimal != null) {
            animals.remove(animal);
            animals.add(newAnimal);
            System.out.println("Животное успешно определено как: " + newAnimal.getSpecificType());
        } else {
            System.out.println("Неверный тип животного.");
        }
    }

    private static void showAnimals() {
        if (animals.isEmpty()) {
            System.out.println("В реестре нет животных.");
            return;
        }

        System.out.println("\nЖивотные в реестре:");
        for (Animal animal : animals) {
            System.out.println(animal.getType() + " (" + animal.getSpecificType() + ") - Имя: " + animal.getName() + ", Возраст: " + animal.getAge());
        }
    }

    private static void trainAnimal() {
        System.out.print("Введите имя животного для обучения: ");
        String name = scanner.nextLine();

        Animal animal = animals.stream().filter(a -> a.getName().equalsIgnoreCase(name)).findFirst().orElse(null);

        if (animal == null) {
            System.out.println("Животное не найдено.");
            return;
        }

        System.out.print("Введите новую команду: ");
        String command = scanner.nextLine();
        animal.addCommand(command);
        System.out.println("Команда успешно добавлена.");
    }

    private static void showAnimalCommands() {
        System.out.print("Введите имя животного для просмотра команд: ");
        String name = scanner.nextLine();

        Animal animal = animals.stream().filter(a -> a.getName().equalsIgnoreCase(name)).findFirst().orElse(null);

        if (animal == null) {
            System.out.println("Животное не найдено.");
            return;
        }

        List<String> commands = animal.getCommands();
        if (commands.isEmpty()) {
            System.out.println("Для этого животного нет команд.");
        } else {
            System.out.println("Команды для " + animal.getName() + ": " + commands);
        }
    }
}