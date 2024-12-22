package practice.functional_interface;

import java.util.ArrayList;

/*
 * Practice below Functional Interfaces
 * 1. Predicate
 * 2. Function
 * 3. Consumer
 * 4. Supplier
 */

import java.util.function.*;

public class Practice7 {
    public static void main(String[] args) {
        // Predicate
        Predicate<String> isFirstLetterA = word -> word.startsWith("A");
        System.out.println(isFirstLetterA.test("Aditya"));

        // Function
        Function<String, Integer> getLength = word -> word.length();
        System.out.println(getLength.apply("ABC"));

        // Consumer
        Consumer<String> print = message -> System.out.println(message);
        print.accept("Halluuu Developer!");

        // SUpplier
        Supplier<ArrayList<String>> getArrayList = () -> new ArrayList<>();
        ArrayList<String> lst = getArrayList.get();

        lst.add("ABC");
        lst.add("ACB");
        
        lst.forEach(System.out::println);
    }
}
