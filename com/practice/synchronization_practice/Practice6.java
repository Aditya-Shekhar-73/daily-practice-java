package practice.synchronization_practice;

/*
 * Implement synchronization in two ways
 * 1. synchronized methods
 * 2. synchronized blocks
 */

class SharedResource {
    private int count1 = 0;
    private int count2 = 0;

    public synchronized void increement1(){
        count1++;
    }

    public int getCount1(){
        return this.count1;
    }

    public void increement2() {
        synchronized(this){
            count2++;
        }
    }

    public int getCount2(){
        return this.count2;
    }
}

public class Practice6 {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        Thread t1 = new Thread(
            () -> {
                for(int i = 0;i < 5;i++){
                    sharedResource.increement1();
                }
            }
        );
        t1.start();
        Thread t2 = new Thread(
            () -> {
                for(int i = 0;i < 8;i++){
                    sharedResource.increement1();
                }
            }
        );
        t2.start();

        Thread t3 = new Thread(
            () -> {
                for (int i = 0; i < 5;i++){
                    sharedResource.increement2();
                }
            }
        );
        t3.start();
        Thread t4 = new Thread(
            () -> {
                for (int i = 0; i< 9;i++){
                    sharedResource.increement2();
                }
            }
        );
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e){
            System.out.println(e.getMessage());
        }

        System.out.println(sharedResource.getCount1());
        System.out.println(sharedResource.getCount2());
    }
}
