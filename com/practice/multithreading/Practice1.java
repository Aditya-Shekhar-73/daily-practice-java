package practice.multithreading;

/*
 * Implement it by extending thread
 * Implement it by implementing runnable interface
 * Implement it using lambda expression
 */

class MyThread1 extends Thread {
    @Override
    public void run(){
        System.err.println("Thread1 is running!");
    }
}

class MyThread2 implements Runnable {
    @Override
    public void run(){
        System.err.println("Thread2 is running!");
    }
}

public class Practice1 {
    public static void main(String[] args) {
        // Using extend Thread
        MyThread1 thread1 = new MyThread1();
        thread1.start();

        // Using Runnable interface
        Thread thread2 = new Thread(new MyThread2());
        thread2.start();

        // Usimg Lambda expression
        Thread thread3 = new Thread(
            () -> System.out.println("Thread3 is running!")
        );
        thread3.start();
    }
}
