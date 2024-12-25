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


class MyThread11 extends Thread {
    @Override
    public void run(){
        System.out.println("Thread1 is started!");
    }
}

class MyRunnable11 implements Runnable {
    @Override
    public void run(){
        System.out.println("Thread2 is started!");
    }
}

class SharedResource11a {
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

class SharedResource11b {
    public void produce() throws InterruptedException{
        synchronized(this){
            System.out.println("Producer thread is started");
            wait();
            System.out.println("Producer thread is resumed!");
        }
    }

    public void consume() {
        synchronized (this){
            System.out.println("Consumer thread is started!");
            notify();
        }
    }
}

public class Practice11 {
    public static void main(String[] args) {
        // 1
        MyThread11 t1 = new MyThread11();
        t1.start();

        // 2
        Thread t2 = new Thread(new MyRunnable11());
        t2.start();

        // 3
        Thread t3 = new Thread(
            () -> System.out.println("Thread3 is started!")
        );
        t3.start();

        // 4 Synchronization
        SharedResource11a sharedResource11a = new SharedResource11a();

        Thread t4 = new Thread(
            () -> {
                for (int i = 0;i < 5;i++) sharedResource11a.increement1();
            }
        );
        Thread t5 = new Thread(
            () -> {
                for (int i = 0;i < 7;i++) sharedResource11a.increement1();
            }
        );

        Thread t6 = new Thread(
            () -> {
                for(int i = 0;i < 8;i++) sharedResource11a.increement2();
            }
        );
        Thread t7 = new Thread(
            () -> {
                for(int i = 0;i < 5;i++) sharedResource11a.increement2();
            }
        );

        t4.start();
        t5.start();
        t6.start();
        t7.start();

        try {
            t4.join();
            t5.join();
            t6.join();
            t7.join();
        } catch (InterruptedException e){
            System.err.println(e.getMessage());
        }

        System.out.println(sharedResource11a.getCount());

        // 5 Concurrency APIs
        // Executors Framework
        ExecutorService executor = Executors.newFixedThreadPool(3);

        try {
            for (int i =0; i< 5; i++){
                executor.execute(
                    () -> {
                        System.out.println(Thread.currentThread().getName());
                    }
                );
            }
        } catch(Exception e) {
            System.err.println(e.getMessage());
        } finally{
            executor.shutdown();
        }

        // Concurrent HashMap
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        map.put(1, "ABC");
        map.put(2, "DEC");
        map.put(3, "ACB");

        map.forEach((key, value) -> System.out.println(key + ": " + value));

        // 6. Inter Thread communications
        SharedResource11b sharedResource11b = new SharedResource11b();
        Thread t8 = new Thread(
            () -> {
                try {
                    sharedResource11b.produce();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        );

        Thread t9 = new Thread(
            () -> sharedResource11b.consume()
        );
        t8.start();
        t9.start();
    }
}
