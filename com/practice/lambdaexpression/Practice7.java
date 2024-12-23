package practice.lambdaexpression;

/*
 * Practice Lambda expression with Custom Functional interface
 */

@FunctionalInterface
interface Greet7{
    public void getMessage();
}

public class Practice7 {
    public static void main(String[] args) {
        Greet7 greet7 = () -> System.out.println("Hallo from custom interface Greet!");
        greet7.getMessage();
    }
}
