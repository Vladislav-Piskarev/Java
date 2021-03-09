public class Cat {

    public String name;
    public int appetite;
    public boolean maxFood;

    public Cat(String name, int appetite, boolean maxFood) {
        this.name = name;
        this.appetite = appetite;
        this.maxFood = maxFood;
    }

    public void Eat(Bowl b) {
        b.downFood(appetite);
    }
}
