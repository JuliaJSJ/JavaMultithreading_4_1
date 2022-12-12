import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class CallCenter {
    private static final int CALLS = 60;
    private static final Queue<String> phoneCalls = new ArrayBlockingQueue<>(CALLS);
    private static final int PAUSE = 1000;
    public static final int ANSWER = 3000;

    public void call(){
        phoneCalls.offer(Thread.currentThread().getName());
        try {
            Thread.sleep(PAUSE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Звонок " + Thread.currentThread().getName());
    }

    public void takeTheCall(){
        while (!phoneCalls.isEmpty()) {
            try {
                Thread.sleep(ANSWER);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Специалист " + Thread.currentThread().getName() + " ответил на звонок " + phoneCalls.poll());
        }
    }
}
