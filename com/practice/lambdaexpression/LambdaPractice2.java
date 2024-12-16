package practice.lambdaexpression;

/*
 * Practice Lambda with custom functional interface
 */

@FunctionalInterface
interface Greet {
    public void getName(String name);
    
}

public class LambdaPractice2 {
    
    public static void main(String[] args) {
        Greet greet = name -> System.err.println(name);

        greet.getName("Alice");
    }
}
