class Dog extends Animal {

    private static int MAX_RUN = 500;
    private static int MAX_SWIM = 10;

    public void run(int i) {
        if (i > MAX_RUN) {
            System.out.println("Dog max run 500");
        } else {
            System.out.println("Dog run " + i);
        }
    }

    public void swim(int j) {
        if (j > MAX_SWIM) {
            System.out.println("Dog max swim 10");
        } else {
            System.out.println("Dog swim " + j);
        }
    }

}
