package practice.synchronization_practice;

/*
 * Implement synchronization in two ways
 * 1. synchronized methods
 * 2. synchronized blocks
 */

class Count1 {
    private int count = 0;
    public synchronized void increement(){
        count++;
    }

    public int getCount(){
        return count;
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
        return count;
    }
}

public class Practice5 {
    public static void main(String[] args) {
        Count1 count1 = new Count1();
        Count2 count2 = new Count2();

        Thread t1 = new Thread(
            () -> {
                for (int i = 0;i < 8;i++) count1.increement();
            }
        );
        Thread t2 = new Thread(
            () -> {
                for (int i = 0;i < 7;i++) count1.increement();
            }
        );

        Thread t3 = new Thread(
            () -> {
                for (int i = 0;i < 6;i++) count2.increement();
            }
        );
        Thread t4 = new Thread(
            () -> {
                for (int i = 0;i < 5;i++) count2.increement();
            }
        );

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e){
            System.err.println(e.getMessage());
        }

        System.out.println(count1.getCount());
        System.out.println(count2.getCount());
    }
}
