import java.util.Scanner;

public class HomeWork_1 {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int food;

        System.out.println("Сколько корма положить?");
        food = sc.nextInt();

        Cat[] cat = new Cat[3];
        cat[0] = new Cat("Кот_1 ", 40, false);
        cat[1] = new Cat("Кот_2 ", 0, false);
        cat[2] = new Cat("Кот_3 ", 4000, false);

        Bowl bowl = new Bowl(food);
        bowl.infoBowl();

        for (int i = 0; i < cat.length; i++) {
            if (!cat[i].maxFood && cat[i].appetite <= bowl.food){
                cat[i].Eat(bowl);
                cat[i].maxFood = false;
                System.out.println(cat[i].name + " поел");
            } else {
                System.out.println(cat[i].name + " не поел");
            }
        }
    }
}
