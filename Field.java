import java.awt.*;

public class Field {

    public int FIELD_SIZE;
    public int CELL_SIZE;
    public char HUMAN_MOVE = 'X';
    public char COMP_MOVE = 'О';
    public char EMPTY = '●';
    public String DRAW = "DRAW";
    public String WIN = "WIN";
    public String LOSE = "LOSE";

    public char[][] map;
    public String gameOver;

    Field(int field_size, int cell_size) {
        FIELD_SIZE = field_size;
        CELL_SIZE = cell_size;
        map = new char[FIELD_SIZE][FIELD_SIZE];
        init();
    }

    void init() {
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                map[i][j] = EMPTY;
                gameOver = null;
            }
        }
    }

    int getSize()
        { return FIELD_SIZE; }

    char getHumanMove()
        { return HUMAN_MOVE; }

    char getCompMove()
        { return COMP_MOVE; }

    boolean isGameOver()
        { return gameOver != null; }

    String getGameOver()
        { return gameOver; }

    void setMove(int x, int y, char move) {
        map[x][y] = move;
        if (checkWin(HUMAN_MOVE)) {
            gameOver = WIN;
        }
        else if (checkWin(COMP_MOVE)) {
            gameOver = LOSE;
        }
        else if (isMapFull()) {
            gameOver = DRAW;
        }
    }

    boolean isMapFull() {
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                if (map[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean checkWin(char move) {
        for (int i = 0; i < FIELD_SIZE; i++) {
            if ((map[i][0] == move && map[i][1] == move && map[i][2] == move) || (map[0][i] == move && map[1][i] == move && map[2][i] == move)) {
                return true;
            }
        }
        if ((map[0][0] == move && map[1][1] == move && map[2][2] == move) || (map[2][0] == move && map[1][1] == move && map[0][2] == move)) {
            return true;
        }
        return false;
    }

    boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x > FIELD_SIZE - 1 || y > FIELD_SIZE - 1) {
            return false;
        }
        if (map[x][y] == EMPTY) {
            return true;
        }
        return false;
    }

    public void paint(Graphics2D g) {
        g.setColor(Color.white);
        for (int i = 1; i < FIELD_SIZE; i++) {
            g.drawLine(0, i*CELL_SIZE, FIELD_SIZE*CELL_SIZE, i*CELL_SIZE);
            g.drawLine(i*CELL_SIZE, 0, i*CELL_SIZE, FIELD_SIZE*CELL_SIZE);
        }

        g.setStroke(new BasicStroke(50));

        for (int y = 0; y < FIELD_SIZE; y++) {
            for (int x = 0; x < FIELD_SIZE; x++) {
                if (map[x][y] == HUMAN_MOVE) {
                    g.setColor(Color.white);
                    g.drawLine(x*CELL_SIZE+CELL_SIZE/4, y*CELL_SIZE+CELL_SIZE/4, (x+1)*CELL_SIZE-CELL_SIZE/4, (y+1)*CELL_SIZE-CELL_SIZE/4);
                    g.drawLine(x*CELL_SIZE+CELL_SIZE/4, (y+1)*CELL_SIZE-CELL_SIZE/4, (x+1)*CELL_SIZE-CELL_SIZE/4, y*CELL_SIZE+CELL_SIZE/4);
                }
                if (map[x][y] == COMP_MOVE) {
                    g.setColor(Color.white);
                    g.drawOval(x*CELL_SIZE+CELL_SIZE/4, y*CELL_SIZE+CELL_SIZE/4, CELL_SIZE/2, CELL_SIZE/2);
                }
            }
        }
    }
}
