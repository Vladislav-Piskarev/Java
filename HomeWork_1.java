import java.util.Scanner;

public class HomeWork_1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите расстояние бега для Кота");
        int a = scanner.nextInt();
        System.out.println("Введите расстояние плавания для Кота");
        int b = scanner.nextInt();
        System.out.println("Введите расстояние бега для Собаки");
        int i = scanner.nextInt();
        System.out.println("Введите расстояние плавания для Собаки");
        int j = scanner.nextInt();

        Cat cat = new Cat();
        cat.run(a);
        cat.swim(b);

        Dog dog = new Dog();
        dog.run(i);
        dog.swim(j);

    }
}
