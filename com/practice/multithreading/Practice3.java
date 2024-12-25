package practice.multithreading;

/*
 * Practice multithreading in three ways
 * 1. Extent Thread class
 * 2. Implement Runnable interface
 * 3. Use Lambda expression
 */

class MyThread3 extends Thread {
    @Override
    public void run(){
        System.out.println("Thread1 is running!");
    }
}

class MyRunnable3 implements Runnable {
    @Override
    public void run(){
        System.out.println("Thread2 is running!");
    }
}


public class Practice3 {
    public static void main(String[] args) {
        // Using Thread extends
        MyThread3 t1 = new MyThread3();
        t1.start();

        // Using Runnable interface
        Thread t2 = new Thread(new MyRunnable3());
        t2.start();

        // Using Lambda expression
        Thread t3 = new Thread(
            () -> System.out.println("Thread3 is running!")
        );
        t3.start();
    }
}
