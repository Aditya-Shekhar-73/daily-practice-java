package practice.multithreading;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * Practice Multithreading
 * 1. Using Thread class
 * 2. Using Runnable interface
 * 3. Using lambda expression
 * 4. Synchronization practice using synchronized method and blocks
 * 5. Concurrency APIs: a. Executors Frameword b. Concurrency Collection using ConcurrentHashMap
 * 6. Inter Thread communications
 */

// 1. Using Thread class
class MyThread15 extends Thread {
    @Override
    public void run(){
        System.out.println("Thread1 is started!");
    }
}

// 2. Using Runnable interface
class MyRunnable15 implements Runnable {
    @Override
    public void run(){
        System.out.println("Thread2 is started!");
    }
}

// 4. Synchronization
class SharedResource15a {
    private int count = 0;

    public synchronized void increement1() {
        count++;
    }

    public void increement2() {
        synchronized(this){
            count++;
        }
    }

    public int getCount(){
        return count;
    }
}

// 5. Inter thread communications
class SharedResource15b {
    public void producer() throws InterruptedException{
        synchronized(this){
            System.out.println("Producer thread is started!");
            System.out.println("Producer thread will be paused!");
            wait();
            System.out.println("Producer thread is resumed!");
        }
    }

    public void consumer() {
        synchronized(this){
            System.out.println("Consumer thread is started!");
            System.out.println("Resuming producer thread!");
            notify();
        }
    }
}


public class Practice15 {
    public static void main(String[] args) {
        // Thread
        MyThread15 t1 = new MyThread15();
        Thread t2 = new Thread(
            new MyRunnable15()
        );
        Thread t3 = new Thread(
            () -> System.out.println("Thread3 is started!")
        );

        // Synchronization
        SharedResource15a sharedResource15a = new SharedResource15a();
        Thread t4 = new Thread(
            () -> {
                for (int i = 0;i < 5;i++) sharedResource15a.increement1();
            }
        );
        Thread t5 = new Thread(
            () -> {
                for (int i = 0;i < 7;i++) sharedResource15a.increement1();
            }
        );
        Thread t6 = new Thread(
            () -> {
                for (int i = 0;i < 5;i++) sharedResource15a.increement2();
            }
        );
        Thread t7 = new Thread(
            () -> {
                for (int i = 0;i < 5;i++) sharedResource15a.increement2();
            }
        );

        // Inter thread communication
        SharedResource15b sharedResource15b = new SharedResource15b();
        Thread t8 = new Thread(
            () -> {
                try {
                    sharedResource15b.producer();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        );
        Thread t9 = new Thread(
            () -> sharedResource15b.consumer()
        );

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
            t6.join();
            t7.join();
            t8.join();
            t9.join();
        } catch (InterruptedException e){
            System.err.println(e.getMessage());
        }

        System.out.println(sharedResource15a.getCount());


        // Executors framework
        ExecutorService executor = Executors.newFixedThreadPool(3);
        
        try {
            for (int i = 0;i < 5; i++){
                executor.execute(
                    () -> System.out.println(Thread.currentThread().getName())
                );
            }
        } catch(Exception e){
            System.err.println(e.getMessage());
        } finally {
            executor.shutdown();
        }

        // Concurrent collection
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();

        map.put(1, "ABC");
        map.put(2, "DEC");
        map.put(3, "JAN");

        map.forEach((key, value) -> System.out.println(key + ":" + value));
    }
}
