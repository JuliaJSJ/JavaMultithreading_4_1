public class Main {
    public static final int CALLS = 60;
    public static final int OPERATORS = 20;

    public static void main(String[] args) {
        CallCenter center = new CallCenter();
        for (int i = 1; i <= CALLS; i++) {
            new Thread(null, center::call, "№ " + i).start();
        }

        for (int i = 1; i <= OPERATORS; i++) {
            new Thread(null, center::takeTheCall, "№ " + i).start();
        }
    }
}
