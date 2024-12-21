package practice.functional_interface;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.lang.Math;

/*
 * Practice below Functional Interfaces
 * 1. Predicate
 * 2. Function
 * 3. Consumer
 * 4. Supplier
 */

public class Practice6 {
    public static void main(String[] args) {
        // Predicate
        Predicate<Integer> isInteger = number -> number instanceof Integer;
        System.out.println(isInteger.test(5));

        // Function
        Function<Integer, Double> getSquare = number -> Math.sqrt(number);
        System.out.println(getSquare.apply(8));

        // Supplier
        Supplier<ConcurrentHashMap<Integer, String>> getConcurrentHashMap = () -> new ConcurrentHashMap<>();
        ConcurrentHashMap<Integer, String> map = getConcurrentHashMap.get();
        
        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(3, "Mango");

        map.forEach((key, value) -> System.out.println(key + ": " + value));

        // Consumer
        Consumer<String> print = message -> System.out.println(message);
        print.accept("Hallo, my name is Adi");
    }
}
