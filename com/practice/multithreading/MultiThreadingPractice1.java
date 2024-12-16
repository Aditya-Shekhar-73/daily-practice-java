package practice.multithreading;

class MyThread extends Thread {
    @Override
    public void run(){
        System.out.println("Thread1 is running");
    }
}

public class MultiThreadingPractice1 {
    public static void main(String[] args) {
        MyThread thread = new MyThread();

        thread.start();
    }
}
