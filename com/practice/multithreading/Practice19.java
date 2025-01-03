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

// Thread creation practice
class MyThread19 extends Thread {
    @Override
    public void run(){
        System.out.println("Thread1 is running!");
    }
}

class MyRunnable19 implements Runnable {
    @Override
    public void run(){
        System.out.println("Thread2 is running!");
    }
}

class TestThreadCreationAndRunning {
    public void test(){
        MyThread19 t1 = new MyThread19();
        t1.start();

        Thread t2 = new Thread(new MyRunnable19());
        t2.start();

        Thread t3 = new Thread(
            () -> System.out.println("Thread3 is running!")
        );
        t3.start();
    }
}

// Synchronization practice
class SharedResource19a {
    private int count = 0;

    // Synchronization methods
    public synchronized void increement1(){
        count++;
    }

    // Synchronization blocks
    public void increement2(){
        synchronized(this){
            count++;
        }
    }

    public int getCount(){
        return this.count;
    }

    public void test(){
        Thread t1 = new Thread(
            () -> {
                for (int i = 0;i < 6;i++) increement1();
            }
        );
        Thread t2 = new Thread(
            () -> {
                for (int i = 0;i < 3;i++) increement1();
            }
        );

        Thread t3 = new Thread(
            () -> {
                for (int i = 0;i < 7;i++) increement2();
            }
        );
        Thread t4 = new Thread(
            () -> {
                for (int i = 0;i < 9;i++) increement2();
            }
        );

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try{
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e){
            System.err.println(e.getMessage());
        }

        System.out.println(getCount());
    }
}

// Inter thread communication
class SharedResource19b{
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
            notify();
        }
    }

    public void test(){
        Thread t1 = new Thread(
            () -> {
                try{
                    producer();
                } catch (InterruptedException e){
                    System.err.println(e.getMessage());
                }
            }
        );

        Thread t2 = new Thread(
            () -> consumer()
        );

        t1.start();
        t2.start();
    }

}

// Concurrency APIs
class ConcurrencyApiPractice {
    // Executors Framework
    public void test1(){
        ExecutorService executor = Executors.newFixedThreadPool(3);

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
    }

    // Concurrent Collections
    public void test2(){
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();

        map.put(1, "PNG");
        map.put(2, "JPEG");

        map.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}

public class Practice19 {
    public static void main(String[] args) {
        // Thread creation practice
        TestThreadCreationAndRunning testThreadCreationAndRunning = new TestThreadCreationAndRunning();
        testThreadCreationAndRunning.test();

        // Synchronization practice
        SharedResource19a sharedResource19a = new SharedResource19a();
        sharedResource19a.test();

        // Inter thread communication practice
        SharedResource19b sharedResource19b = new SharedResource19b();
        sharedResource19b.test();

        // Concurrent APIs practice
        ConcurrencyApiPractice concurrencyApiPractice = new ConcurrencyApiPractice();
        concurrencyApiPractice.test1();
        concurrencyApiPractice.test2();
    }
}
