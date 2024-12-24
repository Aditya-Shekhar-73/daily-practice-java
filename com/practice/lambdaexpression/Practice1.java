package practice.lambdaexpression;

/*
 * Practice lambda with functional interface
 */

@FunctionalInterface
interface  Greet1 {
    public void greet(String message);
    
}

public class Practice1 {
    public static void main(String[] args) {
        Greet1 print = name -> System.out.println(name);

        print.greet("Halloo Guyzzz!!");
    }
}
