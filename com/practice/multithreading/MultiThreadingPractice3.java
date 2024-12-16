package practice.multithreading;

public class MultiThreadingPractice3 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> System.err.println("Thread3 is running"));

        thread.start();
    }
}
