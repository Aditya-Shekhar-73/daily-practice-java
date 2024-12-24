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

class MyThread10 extends Thread{
    public void run(){
        System.out.println("Thread1 is started!");
    }
}

class MyRunnable10 implements Runnable {
    public void run(){
        System.out.println("Thread2 is started!");
    }
}

class SharedResource10a {
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
        return count;
    }
}


class SharedResource10b {
    public void producer() throws InterruptedException {
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


public class Practice10 {
    public static void main(String[] args) {
        // 1
        MyThread10 t1 = new MyThread10();
        t1.start();

        // 2
        Thread t2 = new Thread(new MyRunnable10());
        t2.start();

        // 3
        Thread t3 = new Thread(
            () -> System.out.println("Thread3 is started!")
        );
        t3.start();

        // 4
        SharedResource10a sharedResource10a = new SharedResource10a();

        Thread t4 = new Thread(
            () -> {
                for(int i = 0;i < 4;i++) sharedResource10a.increement1();
            }
        );
        t4.start();
        Thread t5 = new Thread(
            () -> {
                for (int i = 0;i < 3;i++) sharedResource10a.increement1();
            }
        );
        t5.start();

        Thread t8 = new Thread(
            () -> {
                for(int i = 0;i < 4;i++) sharedResource10a.increement2();
            }
        );
        t8.start();
        Thread t9 = new Thread(
            () -> {
                for (int i = 0;i < 3;i++) sharedResource10a.increement2();
            }
        );
        t9.start();

        try {
            t4.join();
            t5.join();
            t8.join();
            t9.join();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        System.out.println(sharedResource10a.getCount());

        // 5 Concurrency APIS
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        try {
            for (int i = 0;i < 5;i++){
                executorService.execute(
                    () -> System.out.println(Thread.currentThread().getName())
                );
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally{
            executorService.shutdown();
        }

        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        map.put(1, "ABCD");
        map.put(2, "DEBA");

        map.forEach((key, value) -> System.out.println(key + ": " + value));

        // 6
        SharedResource10b sharedResource10b = new SharedResource10b();
        Thread t6 = new Thread(
            () -> {
                try {
                    sharedResource10b.producer();
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        );
        t6.start();

        Thread t7 = new Thread(
            () -> sharedResource10b.consumer()
        );
        t7.start();
    }
}
