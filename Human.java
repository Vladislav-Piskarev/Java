public class Human {

    public char MOVE;

    Human(char chr)
        { MOVE = chr; }

    void turn(int x, int y, Field field, Comp comp) {
        if (field.isCellValid(x, y)) {
            if (field.isGameOver()) {
            } else {
                field.setMove(x, y, MOVE);
            }
            if (field.isGameOver()) {
                return;
            }
            comp.turn(field);
        }
    }
}
