import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


class HomeWork_1_8 extends JFrame {

    public String NAME_PROGRAM = "Крестики х Нолики";
    public int WINDOW_SIZE = 500;
    public int WINDOW_X = 7;
    public int WINDOW_Y = 55;
    public int FIELD_SIZE = 3;
    public int CELL_SIZE = WINDOW_SIZE / FIELD_SIZE;
    public String BUTTON_NG = "GAME";

    Panel panel;
    Field field;
    Human human;
    Comp comp;

    public static void main(String args[]) {
        new HomeWork_1_8();
    }

    HomeWork_1_8() {
        setTitle(NAME_PROGRAM);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WINDOW_SIZE + WINDOW_X, WINDOW_SIZE + WINDOW_Y);
        setLocationRelativeTo(null);
        setResizable(false);

        field = new Field(FIELD_SIZE, CELL_SIZE);
        human = new Human(field.getHumanMove());
        comp = new Comp(field.getCompMove());
        panel = new Panel();
        panel.setBackground(Color.orange);
        panel.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                human.turn(e.getX()/CELL_SIZE, e.getY()/CELL_SIZE, field, comp);
                panel.repaint();
                if (field.isGameOver())
                    JOptionPane.showMessageDialog(
                            HomeWork_1_8.this, field.getGameOver());
            }
        });

        JButton init = new JButton(BUTTON_NG);
        init.addActionListener(e -> {
            field.init();
            panel.repaint();
        });

        JPanel panelButton = new JPanel();
        panelButton.add(init);

        setLayout(new BorderLayout());
        add(panelButton, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    class Panel extends JPanel {
        public void paint(Graphics g) {
            super.paint(g);
            field.paint((Graphics2D) g);
        }
    }
}
