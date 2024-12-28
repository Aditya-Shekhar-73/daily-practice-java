package practice.lambdaexpression;

/*
 * Practice lambda expression with custom functional Interface
 */

@FunctionalInterface
interface Greet {
    public void getMessage(String message);
}

public class Practice11 {
    public static void main(String[] args) {
        Greet greet = message -> System.out.println(message);

        greet.getMessage("Hallu from custom functional interface!");
    }
}
