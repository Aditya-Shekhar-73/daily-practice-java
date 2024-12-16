package practice.multithreading;

class MyRunnable implements Runnable{
    @Override
    public void run(){
        System.out.println("Thread 2 is running....");
    }
}


public class MultiThreadingPractice2 {
    public static void main(String[] args) {
        Thread thread = new Thread(
            new MyRunnable()
        );

        thread.start();
    }
}
