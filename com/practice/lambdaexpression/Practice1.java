package practice.lambdaexpression;

/*
 * Practice lambda with functional interface
 */

@FunctionalInterface
interface  Greet {
    public void greet(String message);
    
}

public class Practice1 {
    public static void main(String[] args) {
        Greet print = name -> System.out.println(name);

        print.greet("Halloo Guyzzz!!");
    }
}
