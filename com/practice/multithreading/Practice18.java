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

class MyThread18 extends Thread {
    @Override
    public void run(){
        System.out.println("Thread1 is running!");
    }
}

class MyRunnable18 implements Runnable {
    @Override
    public void run(){
        System.out.println("Thread2 is running!");
    }
}

// Synchronization practice using synchronized method and blocks
class SharedResource18a {
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

    public void test() {
        Thread t1 = new Thread(
            () -> {
                for (int i = 0; i < 3;i++) increement1();
            }
        );
        Thread t2 = new Thread(
            () -> {
                for (int i = 0; i < 5;i++) increement1();
            }
        );

        Thread t3 = new Thread(
            () -> {
                for (int i = 0; i < 3;i++) increement2();
            }
        );
        Thread t4 = new Thread(
            () -> {
                for (int i = 0; i < 2;i++) increement2();
            }
        );

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
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

// Concurrency APIs
class ExecutorsFramework {
    public void test(){
        ExecutorService executor = Executors.newFixedThreadPool(3);

        try{
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
}

class ConcurrentHashMapPractice18 {
    public void createAndPrint(){
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();

        map.put(1, "JPG");
        map.put(2, "JPEG");

        map.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}

// Inter Thread communication
class SharedResource18b {
    public void producer() throws InterruptedException{
        synchronized(this){
            System.out.println("Producer thread is started!");
            wait();
            System.out.println("Consumer has resumed producer thread!");
        }
    }

    public void consumer() {
        synchronized(this){
            System.out.println("Consumer thread is started!");
            notify();
        }
    }

    public void test(){
        Thread t1 = new Thread(
            () -> {
                try {
                    producer();
                } catch (InterruptedException e) {
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

public class Practice18 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable18());
        t1.start();

        MyThread18 t2 = new MyThread18();
        t2.start();

        Thread t3 = new Thread(
            () -> System.out.println("Thread3 is running!")
        );
        t3.start();

        // Synchronization
        SharedResource18a sharedResource18a = new SharedResource18a();
        sharedResource18a.test();

        // Inter thread communication
        SharedResource18b sharedResource18b = new SharedResource18b();
        sharedResource18b.test();

        // COncurrency APIs
        ExecutorsFramework executorsFramework = new ExecutorsFramework();
        executorsFramework.test();

        ConcurrentHashMapPractice18 concurrentHashMapPractice18 = new ConcurrentHashMapPractice18();
        concurrentHashMapPractice18.createAndPrint();
    }
}
