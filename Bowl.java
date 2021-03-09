public class Bowl {

    public int food;
    public Bowl(int food) {
        this.food = food;
    }

    public void downFood(int a) {
        food -= a;
    }

    public void infoBowl() {
        System.out.println("Всего еды в миске: " + food);
    }
}
