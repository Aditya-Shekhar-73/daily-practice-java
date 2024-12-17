package practice.multithreading;

/*
 * Practice Concurrency APIs
 * 
 * 1. Executor Framework
 * 2. Concurrent Collection (Concurrent HashMap)
 */

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ConcurrentHashMap;

public class Practice2 {
    public static void main(String[] args) {
        // Executor Framework
        ExecutorService executor = Executors.newFixedThreadPool(5);

        try {
            int i;
            for(i=0;i<8;i++){
                executor.execute(
                () -> {
                    System.out.println(Thread.currentThread().getName());
                }
            );
            }
        } catch(Exception e){
            System.err.println(e.getMessage());
        } finally {
            executor.shutdown();
        }


        // Concurrent Hashmap
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

        map.put("Name", "Aditya");
        map.put("Company", "ABC");
        map.put("Role", "Developer");

        map.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
