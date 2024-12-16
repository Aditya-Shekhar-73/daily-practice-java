package practice.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ExecutorPractice {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        try {
            for(int i = 0; i < 5; i++){
                executor.execute(
                    () -> {
                        System.err.println(Thread.currentThread().getName());
                    }
                );
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            executor.shutdown();
        }
    }
}
