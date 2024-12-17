package practice.synchronization_practice;

/*
 * 1. Implement synchronization method
 * 2. Implement synchronization block
 */

/*
 * Using synchronization method
 */
class Count1{
    private int count = 0;

    public synchronized void increement(){
        count++;
    }

    public int getCount(){
        return count;
    }
}

/*
 * Using synchronized block
 */
class Count2{
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


public class Practice3 {
    public static void main(String[] args){
        Count1 count1 = new Count1();
        Count2 count2 = new Count2();

        // Synchronized methods
        Thread thread1 = new Thread(
            () -> {
                for(int i = 0;i< 5;i++){
                    count1.increement();
                }
            }
        );
        Thread thread2 = new Thread(
            () -> {
                for (int i = 0;i < 5;i++){
                    count1.increement();
                }
            }
        );

        thread1.start();
        thread2.start();

        // Synchronized blocks
        Thread thread3 = new Thread(
            () -> {
                for(int i = 0;i < 10;i++){
                    count2.increement();
                }
            }
        );
        Thread thread4 = new Thread(
            () -> {
                for(int i = 0;i < 7;i++){
                    count2.increement();
                }
            }
        );
        thread3.start();
        thread4.start();

        try{
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        }catch (InterruptedException  e){
            System.err.println(e.getMessage());
        }

        System.out.println(count1.getCount());
        System.out.println(count2.getCount());
    }
}
