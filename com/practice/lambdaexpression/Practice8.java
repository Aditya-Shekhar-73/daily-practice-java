package practice.lambdaexpression;

/*
 * Practice Lambda expression with Custom Functional interface
 */

@FunctionalInterface
interface Greet8 {
    public void getMessage(String message, int number);
}

public class Practice8 {
    public static void main(String[] args) {
        Greet8 greet8 = (message, number) -> System.out.println(message + number);
        greet8.getMessage("My name is ABC, My age is: ", 27);
    }
}
