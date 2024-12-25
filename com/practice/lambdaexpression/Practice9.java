package practice.lambdaexpression;

/*
 * Practice Lambda expression with Custom Functional interface
 */

@FunctionalInterface
interface Greet9 {
    public void getMessage(String message);
}

public class Practice9 {
    public static void main(String[] args) {
        Greet9 greet9 = message -> System.out.println(message);
        greet9.getMessage("Hallooo Adi Padi!");
    }
}
