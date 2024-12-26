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

class MyThread12 extends Thread {
    @Override
    public void run(){
        System.out.println("Thread1 is started!");
    }
}

class MyRunnable12 extends Thread {
    @Override
    public void run(){
        System.out.println("Thread2 is started!");
    }
}

class SharedResource12a {
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

class SharedResource12b {
    public void producer() throws InterruptedException{
        synchronized(this){
            System.out.println("Producer is started!");
            wait();
            System.out.println("Producer is resumed!");
        }
    }

    public void consumer(){
        synchronized(this){
            System.out.println("Consumer is started!");
            notify();
        }
    }
}


public class Practice12 {
    public static void main(String[] args) {
        SharedResource12a sharedResource12a = new SharedResource12a();
        SharedResource12b sharedResource12b = new SharedResource12b();

        MyThread12 t1 = new MyThread12();
        Thread t2 = new Thread(new MyRunnable12());
        Thread t3 = new Thread(
            () -> System.out.println("Thread3 is started!")
        );

        t1.start();
        t2.start();
        t3.start();

        Thread t4 = new Thread(
            () -> {
                for (int i = 0;i < 4;i++) sharedResource12a.increement1();
            }
        );

        Thread t5 = new Thread(
            () -> {
                for (int i = 0;i < 7;i++) sharedResource12a.increement1();
            }
        );

        Thread t6 = new Thread(
            () -> {
                for (int i = 0;i < 9;i++) sharedResource12a.increement2();
            }
        );

        Thread t7 = new Thread(
            () -> {
                for (int i = 0;i < 3;i++) sharedResource12a.increement2();
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
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(sharedResource12a.getCount());

        Thread t8 = new Thread(
            () -> {
                try {
                    sharedResource12b.producer();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        );
        Thread t9 = new Thread(
            () -> {
                try {
                    sharedResource12b.consumer();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        );
        t8.start();
        t9.start();

        // Concurrency APIs
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        map.put(1, "Chumtu");
        map.put(2, "Puimon");
        map.forEach((key, value) -> System.out.println(key + ":" + value));

        ExecutorService executor = Executors.newFixedThreadPool(3);
        try {
            for (int i = 0;i < 5;i++){
                executor.execute(
                    () -> System.out.println(Thread.currentThread().getName())
                );
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            executor.shutdown();
        }
    }
}
