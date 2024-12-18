package practice.functional_interface;

/*
 * Practice Predicate Functional interface
 * 1. Predicate
 * 2. Function
 * 3. Consumer
 * 4. Supplier
 */

import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.ArrayList;
import java.util.function.Consumer;

public class Practice2 {
    public static void main(String[] args) {
        // Predicate practice
        Predicate<Integer> isEven = number -> number % 2 == 0;
        System.out.println(isEven.test(5));
        System.out.println(isEven.test(6));

        // Function practice
        Function<Integer, Integer> getDoublt = number -> number * 2;
        System.out.println(getDoublt.apply(5));
        System.out.println(getDoublt.apply(8));

        // Consumer practice
        Consumer<String> print = message -> System.out.println(message);
        print.accept("Printing for Consumer Interface!");

        // Supplier interface
        Supplier<ArrayList<String>> getList = () -> new ArrayList<>();
        ArrayList<String> arrayList = getList.get();

        arrayList.add("Adipadi");
        arrayList.add("Barba");
        arrayList.add("Pishmon");

        arrayList.forEach(System.out::println);
    }
}
