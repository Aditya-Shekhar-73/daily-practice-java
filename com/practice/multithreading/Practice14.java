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
class MyThread14 extends Thread{
    public void run(){
        System.out.println("Thread1 is started!");
    }
}

// 2. Using Runnable interface
class MyRunnable14 implements Runnable {
    public void run(){
        System.out.println("Thread2 is started!");
    }
}

// 4. For synchronization implementation
class SharedResource14a {
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

// 6. FOr interthread communication
class SharedResource14b {
    public void producer() throws InterruptedException{
        synchronized(this){
            System.out.println("Producer is started!");
            System.out.println("Pausing producer...");
            wait();
            System.out.println("Producer is resumed!");
        }
    }

    public void consumer() {
        synchronized(this) {
            System.out.println("Consumer is started!");
            System.out.println("Resuming Producer...");
            notify();
        }
    }
}

public class Practice14 {
    public static void main(String[] args) {
        MyThread14 t1 = new MyThread14();
        Thread t2 = new Thread(new MyRunnable14());
        Thread t3 = new Thread(() -> System.out.println("Thread3 is started!"));

        SharedResource14a sharedResource14a = new SharedResource14a();
        Thread t4 = new Thread(
            () -> {
                for(int i = 0; i < 4;i++) sharedResource14a.increement1();
            }
        );
        Thread t5 = new Thread(
            () -> {
                for(int i = 0; i < 4;i++) sharedResource14a.increement1();
            }
        );

        Thread t6 = new Thread(
            () -> {
                for(int i = 0; i < 4;i++) sharedResource14a.increement2();
            }
        );
        Thread t7 = new Thread(
            () -> {
                for(int i = 0; i < 4;i++) sharedResource14a.increement2();
            }
        );

        SharedResource14b sharedResource14b = new SharedResource14b();
        Thread t8 = new Thread(
            () -> {
                try {
                    sharedResource14b.producer();
                } catch (InterruptedException e) {
                    System.err.println(e.getMessage());
                }
            }
        );
        Thread t9 = new Thread(
            () -> sharedResource14b.consumer()
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

        System.out.println(sharedResource14a.getCount());

        // Executors Framework
        ExecutorService executor = Executors.newFixedThreadPool(3);

        try{
            for (int i = 0; i < 4;i++){
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

        // Concurrent HashMap
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        map.put(1, "adi");
        map.put(2, "padi");

        map.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
