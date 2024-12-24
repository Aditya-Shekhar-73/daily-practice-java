package practice.multithreading;

/*
 * Practice Multithreading
 * 1. Using Thread class
 * 2. Using Runnable interface
 * 3. Using lambda expression
 * 4. Synchronization practice using synchronized method and blocks
 * 5. Concurrency APIs: a. Executors Frameword b. Concurrency Collection using ConcurrentHashMap
 * 6. Inter Thread communications
 */

import java.util.concurrent.Executors;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;


class MyThread7 extends Thread {
    public void run(){
        System.out.println("Thread A is started!");
        System.out.println(getName());
    }
}

class MyRunnable7 implements Runnable {
    public void run(){
        System.out.println("Thread B is started!");
    }
}

class SharedResource7 {
    private int count1 = 0;
    private int count2 = 0;

    public synchronized void increement1(){
        count1++;
    }

    public void increement2(){
        synchronized(this){
            count2++;
        }
    }

    public int getCount1(){
        return this.count1;
    }

    public int getCount2(){
        return this.count2;
    }
}

class SharedResource7a {
    public void produce() throws InterruptedException{
        synchronized(this){
            System.out.println("Producer Thread started!");
            wait();
            System.out.println("Producer Thread resumed!");
        }
    }

    public void consumer(){
        synchronized(this){
            System.out.println("Consumer Thread started!");
            notify();
        }
    }
}

public class Practice7 {
    public static void main(String[] args) {
        // Using Thread class
        MyThread7 t1 = new MyThread7();
        t1.start();

        // Using Runnable interface
        Thread t2 = new Thread(
            new MyRunnable7()
        );
        t2.start();

        // Using Lambda interface
        Thread t3 = new Thread(
            () -> System.out.println("Thread C is started")
        );
        t3.start();


        // Synchronization
        SharedResource7 sharedResource = new SharedResource7();
        Thread t4 = new Thread(
            () -> {
                for (int i = 0;i < 7;i++) sharedResource.increement1();
            }
        );
        t4.start();
        Thread t5 = new Thread(
            () -> {
                for (int i = 0;i < 8;i++) sharedResource.increement1();
            }
        );
        t5. start();

        Thread t6 = new Thread(
            () -> {
                for (int i = 0;i < 10;i++) sharedResource.increement2();
            }
        );
        t6.start();
        Thread t7 = new Thread(
            () -> {
                for (int i = 0;i < 4;i++) sharedResource.increement2();
            }
        );
        t7.start();

        try {
            t4.join();
            t5.join();
            t6.join();
            t7.join();
        } catch (InterruptedException e){
            System.err.println(e.getMessage());
        }

        System.out.println(sharedResource.getCount1());
        System.out.println(sharedResource.getCount2());

        // Concurrency APIs
        // 1. Executor Framework
        ExecutorService executor = Executors.newFixedThreadPool(3);

        try {
            for (int i = 0;i < 5;i++){
                executor.execute(
                    () -> {
                         System.out.println(Thread.currentThread().getName());
                    }
                );
            }
        } catch (Exception e){
            System.err.println(e.getMessage());
        } finally {
            executor.shutdown();
        }

        // 2. Concurrent HashMap
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();

        map.put(1, "Aditya");
        map.put(2, "Abhi");
        map.put(3, "Roshan");

        map.forEach((key, value) -> System.out.println(key + ": " + value));

        // Inter Thread communication
        SharedResource7a sharedResource2 = new SharedResource7a();
        Thread t8 = new Thread(
            () -> {
                try {
                    sharedResource2.produce();
                } catch (InterruptedException e){
                    System.err.println(e.getMessage());
                }
            }
        );
        Thread t9 = new Thread(
            () -> sharedResource2.consumer()
        );
        t8.start();
        t9.start();

        try{
            t8.join();
            t9.join();
        } catch(InterruptedException e){
            System.err.println(e.getMessage());
        }
    }
}
