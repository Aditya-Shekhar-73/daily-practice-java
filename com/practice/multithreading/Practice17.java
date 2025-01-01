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

class MyThread17 extends Thread {
    @Override
    public void run(){
        System.out.println("Thread1 is running!");
    }
}

class MyRunnable17 implements Runnable {
    @Override
    public void run(){
        System.out.println("Thread2 is running!");
    }
}

class SharedResource17a {
    private int count = 0;

    public synchronized void increement1() {
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

// Inter Thread communication

class SharedResource17b {
    public void producer() throws InterruptedException{
        synchronized(this){
            System.out.println("Producer thread is started!");
            wait();
            System.out.println("Producer thread is resumed!");
        }
    }

    public void consumer() {
        synchronized(this){
            System.out.println("Consumer thread is started!");
            notify();
        }
    }
}

// Executors framework
class ExecutorFramework {
    public ExecutorService getExecutor(){
        ExecutorService executor = Executors.newFixedThreadPool(3);
        return executor;
    }

    public void run(){
        ExecutorService executor = getExecutor();

        try {
            
            for (int i = 0; i< 5;i++){
                executor.execute(() -> System.out.println(Thread.currentThread().getName()));
            }
        } catch (Exception e){
            System.err.println(e.getMessage());
        } finally {
            executor.shutdown();
        }
    }
}

// Concurrent Hash Map
class ConcurrentHashMapPractice17 {
    public void createAndPrint(){
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

        map.put("1", "ABC");
        map.put("2", "ABC");
        map.put("3", "ABC");

        map.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}


public class Practice17 {
    public static void main(String[] args) {
        MyThread17 t1 = new MyThread17();
        t1.start();

        Thread t2 = new Thread(new MyRunnable17());
        t2.start();

        Thread t3 = new Thread(() -> System.out.println("Thread3 is running!"));
        t3.start();

        SharedResource17a sharedResource17a = new SharedResource17a();

        Thread t4 = new Thread(
            () -> {
                for (int i = 0; i< 5;i++) sharedResource17a.increement1();
            }
        );
        Thread t5 = new Thread(
            () -> {
                for (int i = 0; i< 5;i++) sharedResource17a.increement1();
            }
        );
        Thread t6 = new Thread(
            () -> {
                for (int i = 0; i< 5;i++) sharedResource17a.increement2();
            }
        );
        Thread t7 = new Thread(
            () -> {
                for (int i = 0; i< 5;i++) sharedResource17a.increement2();
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

        SharedResource17b sharedResource17b = new SharedResource17b();

        Thread t8 = new Thread(
            () -> {
                try{
                    sharedResource17b.producer();
                } catch(InterruptedException e){
                    System.err.println(e.getMessage());
                }
            }
        );
        t8.start();

        Thread t9 = new Thread(
            () -> sharedResource17b.consumer()
        );
        t9.start();

        ExecutorFramework executorFramework = new ExecutorFramework();
        executorFramework.run();

        ConcurrentHashMapPractice17 concurrentHashMapPractice17 = new ConcurrentHashMapPractice17();
        concurrentHashMapPractice17.createAndPrint();
    }
}
