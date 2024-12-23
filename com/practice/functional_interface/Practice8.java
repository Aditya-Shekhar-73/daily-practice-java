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

public class Practice8 {
    public static void main(String[] args) {
        // Predicate
        Predicate<String> containsA = word -> word.toLowerCase().contains("a");
        System.out.println(containsA.test("Arup"));

        // Function
        Function<String, Integer> getLength = word -> word.length();
        System.out.println(getLength.apply("Words"));

        // Supplier
        Supplier<ArrayList<Integer>> getArrayList = ArrayList:: new;

        ArrayList<Integer> list = getArrayList.get();
        list.add(1);
        list.add(2);
        list.add(3);

        list.forEach(System.out::println);

        // Consumer
        Consumer<String> print = message -> System.out.println(message);
        print.accept("Hallo from consumers Funtional interface!");
    }
}
