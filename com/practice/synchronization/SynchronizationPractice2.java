/*
 * Practice Synchronization block
 */

class Count{
    private int count = 0;
    
    public void increement(){
        synchronized (this) {
            count++;
        }
    }

    public int getCount(){
        return count;
    }
}

public class SynchronizationPractice2 {
    public static void main(String[] args) {
        Count count = new Count();

        Thread thread1 = new Thread(
            () -> {
                for(int i = 0; i < 5; i++){
                    count.increement();
                }
            }
        );

        Thread thread2 = new Thread(
            () -> {
                for(int i = 0; i < 6; i++){
                    count.increement();
                }
            }
        );

        thread1.start();
        thread2.start();

        try{
            thread1.join();
            thread2.join();
        } catch (InterruptedException e){
            System.err.println(e.getMessage());
        } finally {
            System.err.println(count.getCount());
        }
    }
}
