package practice.multithreading;

/*
 * Practice multithreading
 * 1. Create Thread by extending Thread class
 * 2. Create Thread using Runnable Interface
 * 3. Create Thread using Lambda expression
 * 4. Practice Executor Framework
 * 5. Practice Concurrent Collection using Concurrent HashMap
 * 
 * Practice inter Thread communication using wait and notify
 */

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ConcurrentHashMap;

class MyThread extends Thread {
    public void run(){
        System.out.println("Thread1 is running!");
    }
}

class MyRunnable implements Runnable {
    public void run(){
        System.out.println("Thread2 is running!");
    }
}

class SharedResources {
    public synchronized void producer() throws InterruptedException{
        System.out.println("Producer Thread started!");
        System.out.println("Producer Thread has been paused!");
        wait();
        System.out.println("Producer Thread Resumed!");
    }

    public synchronized void consumer(){
        System.out.println("Consumer Thread started!");
        System.out.println("Resuming Producer thread from consumer thread!");
        notify();
    }
}

public class Practice5 {
    public static void main(String[] args) {
        // Method 1
        MyThread t1 = new MyThread();
        t1.start();

        // Method 2
        Thread t2 = new Thread(new MyRunnable());
        t2.start();

        // Method 3
        Thread t3 = new Thread(
            () -> System.out.println(Thread.currentThread().getName())
        );
        t3.start();

        // Inter Thread communication practice
        SharedResources resource = new SharedResources();
        
        Thread producer = new Thread(
            () -> {
                try {
                    resource.producer();
                } catch (InterruptedException e){
                    System.err.println(e.getMessage());
                }
            }
        );
        producer.start();

        Thread consumer = new Thread(
            () -> resource.consumer()
        );
        consumer.start();

        // Executor Practice
        ExecutorService executor = Executors.newFixedThreadPool(3);

        try {
            for (int i = 0;i < 5;i++){
                executor.execute(
                    () -> System.out.println(Thread.currentThread().getName())
                );
            }
        } catch (Exception e){
            System.err.println(e.getMessage());
        } finally {
            executor.shutdown();
        }

        // Concurrent HasMap practice
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        map.put("Total Errors", 9);
        map.put("Total Success", 4);

        map.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
