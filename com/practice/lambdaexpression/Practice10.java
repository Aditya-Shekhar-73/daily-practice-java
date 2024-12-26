package practice.lambdaexpression;

/*
 * Practice Lambda expression with Custom Functional interface
 */

@FunctionalInterface
interface Greet10 {
    public void printMessage(String message);
}

public class Practice10 {
    public static void main(String[] args) {
        Greet10 greet = (message) -> System.out.println(message);

        greet.printMessage("Hallo from custom functional Interface");
    }
}
