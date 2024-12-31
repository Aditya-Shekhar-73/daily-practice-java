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

class MyThread16 extends Thread{
    @Override
    public void run(){
        System.out.println("Thread1 is started!");
    }
}

class MyRunnable16 implements Runnable {
    @Override
    public void run(){
        System.out.println("Thread2 is started!");
    }
}

// Synchronization
class SharedResource16a {
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

// For inter thread comm
class SharedResource16b {
    public void producer() throws InterruptedException{
        synchronized(this){
            System.out.println("Producer is started!");
            System.out.println("Pausing producer thread....");
            wait();
            System.out.println("Producer is resumed!");
        }
    }

    public void consumer(){
        synchronized(this){
            System.out.println("Consumer is started!");
            System.out.println("Resuming producer....");
            notify();
        }
    }
}


public class Practice16{
    public static void main(String[] args) {
        // Thread creation
        MyThread16 t1 = new MyThread16();
        Thread t2 = new Thread(new MyRunnable16());
        Thread t3 = new Thread(
            () -> System.out.println("Thread3 is started!")
        );

        // Synchronization
        SharedResource16a sharedResource16a = new SharedResource16a();
        Thread t4 = new Thread(
            () -> {
                for (int i = 0; i < 6;i++) sharedResource16a.increement1();
            }
        );
        Thread t5 = new Thread(
            () -> {
                for (int i = 0; i < 6;i++) sharedResource16a.increement1();
            }
        );

        Thread t6 = new Thread(
            () -> {
                for (int i = 0; i < 2;i++) sharedResource16a.increement2();
            }
        );
        Thread t7 = new Thread(
            () -> {
                for (int i = 0; i < 2;i++) sharedResource16a.increement2();
            }
        );

        // Inter thread comm
        SharedResource16b sharedResource16b = new SharedResource16b();
        Thread t8 = new Thread(
            () -> {
                try {
                    sharedResource16b.producer();
                } catch(InterruptedException e){
                    System.err.println(e.getMessage());
                }
            }
        );
        
        Thread t9 = new Thread(
            () -> sharedResource16b.consumer()
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
            t8.join();
            t9.join();
        } catch (InterruptedException e){
            System.err.println(e.getMessage());
        }

        System.out.println(sharedResource16a.getCount());

        // Concurrency APIs

        ExecutorService executor = Executors.newFixedThreadPool(3);

        try {
            int i = 5;
            while (i == 0) {
                executor.execute(
                    () -> System.out.println(Thread.currentThread().getName())
                );
                i--;
            }
        } catch (Exception e){
            System.err.println(e.getMessage());
        } finally {
            executor.shutdown();
        }

        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
        map.put(1, 123);
        map.put(2, 456);
        map.put(3, 879);
        map.forEach((key, value) -> System.out.println(key + ":" + value));
    }
}