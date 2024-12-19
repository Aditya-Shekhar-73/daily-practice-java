package practice.lambdaexpression;

/*
 * Practice lamda expression with custom Functional Interface
 */

@FunctionalInterface
interface InnerPractice3 {
    public void getName(String name);
}

public class Practice3 {
    public static void main(String[] args) {
        InnerPractice3 practice = name -> System.out.println(name.toLowerCase());
        practice.getName("Aliceeee");
    }
}
