package practice.lambdaexpression;

/*
 * Practice Lambda expression with Custom Functional interface
 */

interface Greet {
    public void getName(String name);
}

public class Practice6 {
    public static void main(String[] args) {
        Greet greet = (name) -> System.out.println(name);
        greet.getName("ABCDE");
    }
}
