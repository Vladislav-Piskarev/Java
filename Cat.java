class Cat extends Animal {

    private static int MAX_RUN = 200;

    public void run(int a) {
        if (a > MAX_RUN) {
            System.out.println("Cat max run 200");
        } else {
            System.out.println("Cat run " + a);
        }
    }

    public void swim(int b) {
        System.out.println("Cat can't swim");
    }

}
