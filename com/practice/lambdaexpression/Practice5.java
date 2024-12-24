package practice.lambdaexpression;

/*
 * Practice Lambda expression with Custom Functional interface
 */

@FunctionalInterface
interface Greet5 {
    public void sayHello(String name);
}

public class Practice5 {
    public static void main(String[] args) {
        Greet5 greet = name -> System.out.println("Hallo " + name + "!");

        greet.sayHello("AdiPadi");
    }
}
