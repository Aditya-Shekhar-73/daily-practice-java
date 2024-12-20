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
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

class MyThread extends Thread {
    public void run() {
        System.out.println("Thread1 is started!");
    }
}

class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Thread2 is started!");
    }
}

class SharedResource {
    public synchronized void produce() throws InterruptedException {
        System.out.println("Producer Thread Started!");
        wait();
        System.out.println("Producer Thread Resumed!");
    }

    public synchronized void consume() {
        System.out.println("Consumer Thread started and resumming producer thread!");
        notify();
    }
}

public class Practice6 {
    public static void main(String[] args) {
        // Thread 1
        MyThread t1 = new MyThread();
        t1.start();

        // Thread 2
        Thread t2 = new Thread(
                new MyRunnable());
        t2.start();

        // Thread 3
        Thread t3 = new Thread(
                () -> System.out.println("Thread3 is started!"));
        t3.start();

        // Executor framework
        ExecutorService executor = Executors.newFixedThreadPool(3);

        try {
            for (int i = 0; i < 5; i++) {
                executor.execute(
                        () -> System.out.println(Thread.currentThread().getName()));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            executor.shutdown();
        }

        // Concurrent HashMap
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("Name", "Aditya");
        map.put("Org", "ABC");
        map.put("Role", "Developer");

        map.forEach((key, value) -> System.out.println(key + ": " + value));

        SharedResource sharedResource = new SharedResource();

        // Inter Thread communication

        Thread t4 = new Thread(
                () -> {
                    try {
                        sharedResource.produce();
                    } catch (InterruptedException e) {
                        System.err.println(e.getMessage());
                    }
                });
        t4.start();

        Thread t5 = new Thread(
            () -> sharedResource.consume()
        );
        t5.start();
    }
}
