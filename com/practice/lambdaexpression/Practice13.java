package practice.lambdaexpression;

/*
 * Practice lambda expression with custom functional Interface
 */

@FunctionalInterface
interface Greet13 {
    public String getMessage(String message); 
}

public class Practice13 {
    public static void main(String[] args) {
        Greet13 greet13 = message -> message.toLowerCase();

        System.out.println(greet13.getMessage("Hallu From Functional Interface!"));
    }
}
