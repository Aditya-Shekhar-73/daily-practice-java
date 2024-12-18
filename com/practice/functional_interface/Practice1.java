package practice.functional_interface;

/*
 * Practice Predicate Functional interface
 * 1. Predicate
 * 2. Function
 * 3. Consumer
 * 4. Supplier
 */

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Practice1 {
    public static void main(String[] args) {
        // Predicate
        Predicate<Integer> isEven = number -> number % 2 == 0;
        System.out.println(isEven.test(23));
        System.out.println(isEven.test(2));

        // Function
        Function<String, Integer> getLength = word -> word.length();
        System.err.println(getLength.apply("Barba"));

        // Consumer
        Consumer<String> print = message -> System.err.println(message);
        print.accept("Hello from consumer method!");

        // Supplier
        Supplier<ArrayList<String>> getArrayList = ArrayList::new;
        ArrayList<String> arrayList = getArrayList.get();
        arrayList.add("Paimon");
        arrayList.add("Adi");
        arrayList.add("Panda");
        arrayList.forEach(System.out::println);
    }
}
