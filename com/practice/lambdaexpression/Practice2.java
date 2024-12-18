package practice.lambdaexpression;

/*
 * Practice Lambda expression with custom Functional interface
 */

@FunctionalInterface
interface Greet {
    void getMessage(String message);
}

public class Practice2 {
    public static void main(String[] args) {
        Greet greet = message -> System.out.println(message);

        greet.getMessage("Halloo Alice!");
    }
}
