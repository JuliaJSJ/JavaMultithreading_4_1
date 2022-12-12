public class Main {
    public static final int CALLS = 60;
    public static final int SPECIALISTS = 10;

    public static void main(String[] args) {
        CallCenter center = new CallCenter();
        for (int i = 1; i <= CALLS; i++) {
            new Thread(null, center::call, "№ " + i).start();
        }

        for (int i = 1; i <= SPECIALISTS; i++) {
            new Thread(null, center::takeTheCall, "№ " + i).start();
        }
    }
}
