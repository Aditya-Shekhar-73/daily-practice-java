package practice.lambdaexpression;

/*
 * Practice Lambda expression with custom Functional interface
 */

@FunctionalInterface
interface Greet2 {
    void getMessage(String message);
}

public class Practice2 {
    public static void main(String[] args) {
        Greet2 greet = message -> System.out.println(message);

        greet.getMessage("Halloo Alice!");
    }
}
