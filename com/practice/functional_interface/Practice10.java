package practice.functional_interface;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/*
 * Practice below Functional Interfaces
 * 1. Predicate
 * 2. Function
 * 3. Consumer
 * 4. Supplier
 */


public class Practice10 {
    public static void main(String[] args) {
        Predicate<String> containsA = word -> word.contains("A");
        System.out.println(containsA.test("Array"));
        System.out.println(containsA.test("List"));

        Function<String, Integer> getLength = word -> word.length();
        System.out.println(getLength.apply("ABCD"));

        Supplier<ArrayList<Integer>> getArrayList = ArrayList::new;
        ArrayList<Integer> lst = getArrayList.get();

        lst.add(45);
        lst.add(56);
        lst.add(43);
        lst.add(68);

        lst.forEach(System.out::println);

        Consumer<String> print = message -> System.out.println(message);
        print.accept("Hallu from Functional Interface practice.");
    }
}