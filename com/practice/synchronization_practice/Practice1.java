package practice.synchronization_practice;

class Counter {
    private int count = 0;

    public synchronized void increement(){
        count ++;
    }

    public int getCount(){
        return count;
    }
}

public class Practice1 {
    public static void main(String[] args) {
        Counter count = new Counter();
        Thread thread1 = new Thread(() -> { for(int i = 0; i < 5; i++) count.increement();});

        Thread thread2 = new Thread(() -> { 
            for(int i = 0; i < 5; i++){
            count.increement();
        }});

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }

        System.err.println(count.getCount());

    }
}
