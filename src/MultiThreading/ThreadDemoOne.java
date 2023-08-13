package MultiThreading;

public class ThreadDemoOne extends Thread {
    public ThreadDemoOne(String message) {
        super(message);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Execution Started");
        for (int i = 0; i < 100; i++) {
            System.out.print("$");
        }
        System.out.println(Thread.currentThread().getName() + " Execution Complted");
    }

    public static void main(String[] args) {

    }
}
