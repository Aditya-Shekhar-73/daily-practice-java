package practice.lambdaexpression;

/*
 * Practice Lambda expression with Custom Functional interface
 */

@FunctionalInterface
interface Greet {
    public void sayHello(String name);
}

public class Practice5 {
    public static void main(String[] args) {
        Greet greet = name -> System.out.println("Hallo " + name + "!");

        greet.sayHello("AdiPadi");
    }
}
