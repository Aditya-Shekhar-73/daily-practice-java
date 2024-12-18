package practice.multithreading;

/*
 * Concurrency APIs
 * 1. Executor Framework
 * 2. Concurrency Collection (We will implmenet ConcurrentHasMap here)
 */

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ConcurrentHashMap;;

public class Practice4 {
    public static void main(String[] args) {
        // Excecutor Framework
        ExecutorService executor = Executors.newFixedThreadPool(3);

        try {
            for (int i = 0; i < 5;i++){
                executor.execute(
                () -> System.out.println(Thread.currentThread().getName())
            );
            }  
        } catch(Exception e){
            System.err.println(e.getMessage());
        } finally {
            executor.shutdown();
        }

        // Concurrent HashMap
        ConcurrentHashMap<String, String> hasMap = new ConcurrentHashMap<>();

        hasMap.put("Name", "Aditya");
        hasMap.put("Company", "ABC");
        hasMap.put("Role", "Dev");


        hasMap.forEach((key, value) -> System.out.println(key + ": "+ value));
    }
}
