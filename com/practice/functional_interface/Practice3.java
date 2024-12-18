package practice.functional_interface;

/*
 * Practice four functional interfaces
 * 
 * 1. Predicate
 * 2. Function
 * 3. Supplier
 * 4. Consumer
 */

import java.util.function.Predicate;
import java.util.function.Function;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Practice3 {
    public static void main(String[] args) {
        // Predicate
        Predicate<String> isStartsWithA = word -> word.startsWith("A");
        System.out.println(isStartsWithA.test("Aditya"));
        System.out.println(isStartsWithA.test("Prastar"));

        // Function
        Function<String, Number> getLength = word -> word.length();
        System.out.println(getLength.apply("Aditya"));

        // Supplier
        Supplier<ArrayList<String>> getArrayList = () -> new ArrayList<>();
        ArrayList<String> list = getArrayList.get();

        list.add("Aditya");
        list.add("Barba");
        list.add("Parrrmon");

        list.forEach(System.out::println);

        // Consumer
        Consumer<String> print = message -> System.out.println(message);
        print.accept("Halluu barba!");

    }
}
