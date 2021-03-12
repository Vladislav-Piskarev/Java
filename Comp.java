import java.util.Random;

public class Comp {

    public char MOVE;
    public Random random;

    Comp(char chr) {
        MOVE = chr;
        random = new Random();
    }

    void turn(Field field) {
        int x, y;
        do {
            x = random.nextInt(field.getSize());
            y = random.nextInt(field.getSize());
        } while (!field.isCellValid(x, y));
        field.setMove(x, y, MOVE);
    }
}
