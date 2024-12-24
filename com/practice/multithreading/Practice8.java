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

class MyThread8 extends Thread {
    public void run(){
        System.out.println("Thread1 is started!");
    }
}

class MyRunnable8 implements Runnable {
    public void run(){
        System.out.println("Thread2 is started!");
    }
}

class SharedResource8a {
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

class SharedResource8b {
    public void producer() throws InterruptedException{
        synchronized(this){
            System.out.println("Producer is started!");
            wait();
            System.out.println("Producer is resumed!");
        }
    }

    public void consumer() {
        synchronized(this){
            System.out.println("Consumer is started!");
            notify();
        }
    }
}


// Main class
public class Practice8 {
    public static void main(String[] args) {
        SharedResource8a sharedResource1 = new SharedResource8a();
        SharedResource8b sharedResource2 = new SharedResource8b();

        MyThread8 t1 = new MyThread8();
        t1.start();

        Thread t2 = new Thread(new MyRunnable8());
        t2.start();

        Thread t3 = new Thread(
            () -> System.out.println("Thread3 is started!")
        );
        t3.start();

        // Synchronization implements
        Thread t4 = new Thread(
            () -> {
                for (int i = 0; i < 4;i++) sharedResource1.increement1();
            }
        );
        Thread t5 = new Thread(
            () -> {
                for (int i = 0; i < 7;i++) sharedResource1.increement1();
            }
        );
        t4.start();
        t5.start();

        Thread t6 = new Thread(
            () -> {
                for (int i = 0; i < 6;i++) sharedResource1.increement2();
            }
        );
        Thread t7 = new Thread(
            () -> {
                for (int i = 0; i < 9;i++) sharedResource1.increement2();
            }
        );
        t6.start();
        t7.start();

        try {
            t4.join();
            t5.join();
            t6.join();
            t7.join();
        } catch (InterruptedException e){
            System.out.println(e.getMessage());
        }

        System.out.println(sharedResource1.getCount1());
        System.out.println(sharedResource1.getCount2());

        // Concurrency APIs
        // Executor API implementation
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        try{
            for (int i = 0;i < 6;i++){
                executorService.execute(
                    () -> System.out.println(Thread.currentThread().getName())
                );
            }
        } catch (Exception e){
            System.err.println(e.getMessage());
        } finally {
            executorService.shutdown();
        }

        // Concurrent Collection
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();

        map.put(1, "ABC");
        map.put(2, "AMB");
        map.put(3, "CDB");

        map.forEach((key, value) -> System.out.println(key + ": " + value));

        // Inter Thread communication implementation
        Thread t8 = new Thread(
            () -> {
                try {
                    sharedResource2.producer();
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

        try {
            t8.join();
            t9.join();
        } catch (InterruptedException e){
            System.err.println(e.getMessage());
        }

        System.out.println("End of Execution!");
    }
}
