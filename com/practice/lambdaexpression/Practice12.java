package practice.lambdaexpression;

/*
 * Practice lambda expression with custom functional Interface
 */

@FunctionalInterface
interface Greet12 {
    public void getMessage(String message);
}

public class Practice12 {
    public static void main(String[] args) {
        Greet12 greet12 = (message) -> System.out.println(message);
        greet12.getMessage("Hallu from lambda functional interface!");
    }
}
