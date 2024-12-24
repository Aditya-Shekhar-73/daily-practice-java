package practice.lambdaexpression;

/*
 * Practice lambda expression using custom functional interface
 */

@FunctionalInterface
interface Greet4  {
    public void getMessage(String message);    
}

public class Practice4 {
    public static void main(String[] args) {
        Greet4 greet = message -> System.out.println(message.toLowerCase());

        greet.getMessage("Hallo Ameee!");
    }
}
