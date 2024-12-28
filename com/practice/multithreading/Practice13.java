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


class MyThread13 extends Thread {
    @Override
    public void run(){
        System.out.println("Thread1 is running!");
    }
}

class MyRunnable13 implements Runnable {
    @Override
    public void run(){
        System.out.println("Thread2 is running!");
    }
}

// For Synchronization
class SharedResource13a {
    private int count = 0;

    public synchronized void increement1(){
        count++;
    }

    public void increement2(){
        synchronized(this){
            count++;
        }
    }

    public int getCount(){
        return this.count;
    }
}

// For inter thread communication
class SharedResource13b {
    public void producer() throws InterruptedException{
        synchronized(this){
            System.out.println("Producer thread is started!");
            wait();
            System.out.println("Producer thread is resumed!");
        }
    }

    public void consumer(){
        synchronized(this){
            System.out.println("Consumer thread is started!");
            System.out.println("Resuming Producer thread!");
            notify();
        }
    }
}

// For executor implementation
class ExecutorsClass13 {
    public ExecutorService getExecutor(){
        ExecutorService executor = Executors.newFixedThreadPool(3);
        return executor;
    }
}

public class Practice13 {
    public static void main(String[] args) {
        // Thread creation methods
        MyThread13 t1 = new MyThread13();
        Thread t2 = new Thread(new MyRunnable13());
        Thread t3 = new Thread(() -> System.out.println("Thread3 is started"));

        // Synchronization implementation
        SharedResource13a  sharedResource13a = new SharedResource13a();

        Thread t4 = new Thread(
            () -> {
                for (int i = 0;i < 3;i++) sharedResource13a.increement1();
            }
        );
        Thread t5 = new Thread(
            () -> {
                for (int i = 0;i < 5;i++) sharedResource13a.increement1();
            }
        );
        Thread t6 = new Thread(
            () -> {
                for (int i = 0;i < 3;i++) sharedResource13a.increement2();
            }
        );
        Thread t7 = new Thread(
            () -> {
                for (int i = 0;i < 3;i++) sharedResource13a.increement2();
            }
        );

        // Inter Thread communication
        SharedResource13b sharedResource13b = new SharedResource13b();

        Thread t8 = new Thread(
            () -> {
                try {
                    sharedResource13b.producer();
                } catch (InterruptedException e){
                    System.err.println(e.getMessage());
                }
            }
        );
        Thread t9 = new Thread(
            () -> sharedResource13b.consumer()
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

        System.out.println(sharedResource13a.getCount());

        // Executors Frameword
        ExecutorsClass13 executorsClass13 = new ExecutorsClass13();

        ExecutorService executor = executorsClass13.getExecutor();

        try {
            for (int i = 0; i < 5;i++){
                executor.execute(
                    () -> System.out.println(Thread.currentThread().getName())
                );
            }
        } catch (Exception e){
            System.err.println(e.getMessage());
        } finally {
            executor.shutdown();
        }

        // Concurrent HashMap
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        map.put(1, "ABC");
        map.put(2, "BEC");

        map.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
