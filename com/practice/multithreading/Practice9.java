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


class MyThread extends Thread {
    // @Override
    public void run(){
        System.out.println("Thread1 is running!");
    }
}

class MyRunnable implements Runnable {
    // @Override
    public void run(){
        System.out.println("Thread2 is running!");
    }
}

class SharedResource1 {
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

class SharedResource2 {
    public void producer() throws InterruptedException{
        synchronized(this){
            System.out.println("Producer is started!");
            wait();
            System.out.println("Producer is resumed!");
        }
    }
    
    public void consumer (){
        synchronized(this){
            System.out.println("Consumer is started and asking producer to resume its execution!");
            notify();
        }
    }
}


public class Practice9 {
    public static void main(String[] args) {
        // 1
        MyThread t1 = new MyThread();
        t1.start();

        //2
        Thread t2 = new Thread(new MyRunnable());
        t2.start();

        //3
        Thread t3 = new Thread(
            () -> System.out.println("Thread3 is started!")
        );
        t3.start();

        //4
        SharedResource1 sharedResource1 = new SharedResource1();

        Thread t4 = new Thread(
            () -> {
                for (int i = 0; i <9; i++) sharedResource1.increement1();
            }
        );
        Thread t5 = new Thread(
            () -> {
                for (int i = 0; i <10; i++) sharedResource1.increement1();
            }
        );

        Thread t6 = new Thread(
            () -> {
                for (int i = 0; i <11; i++) sharedResource1.increement2();
            }
        );
        Thread t7 = new Thread(
            () -> {
                for (int i = 0; i <2; i++) sharedResource1.increement2();
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
        } catch( InterruptedException e){
            System.out.println(e.getMessage());
        }

        System.out.println(sharedResource1.getCount());

        //5
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        try {
            for (int i = 0; i< 8;i++){
                executorService.execute(() -> System.out.println(Thread.currentThread().getName()));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            executorService.shutdown();
        }

        //5 b.
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        map.put(1, "ABC");
        map.put(2, "DCA");

        map.forEach((key, value) -> System.out.println(key + ": " + value));

        // 6
        SharedResource2 sharedResource2 = new SharedResource2();

        Thread t8 = new Thread(
            () -> {
                try {
                    sharedResource2.producer();
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        );
        Thread t9 = new Thread(
            () -> {
                try {
                    sharedResource2.consumer();
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        );
        t8.start();
        t9.start();
    }
}
