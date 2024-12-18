package practice.synchronization_practice;

/*
 * Practice Synchronization with below two ways
 * 1. synchronized blocks
 * 2. synchronized methods
 */

class Count {
    private int count = 0;

    public synchronized void increement(){
        count++;
    }

    public int getCount(){
        return this.count;
    }
}

class Count2 {
    private int count = 0;

    public void increement(){
        synchronized(this){
            count++;
        }
    }

    public int getCount(){
        return this.count;
    }
}


public class Practice4 {
    public static void main(String[] args) {
        Count count1 = new Count();
        Count2 count2 = new Count2();

        // Synchronized method
        Thread t1 = new Thread(() -> {
            for(int i = 0; i < 6;i++) count1.increement();
        });
        Thread t2 = new Thread(
            () -> {
                for(int i = 0; i < 8;i++) count1.increement();
            }
        );
        t1.start();
        t2.start();

        // Synchronized blocks
        Thread t3 = new Thread(() -> {
            for(int i = 0; i < 4;i++) count2.increement();
        });
        Thread t4 = new Thread(
            () -> {
                for(int i = 0; i < 8;i++) count2.increement();
            }
        );

        t3.start();
        t4.start();

        try{
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch(InterruptedException e){
            System.err.println(e.getMessage());
        }

        System.out.println(count1.getCount());
        System.out.println(count2.getCount());

    }
}
