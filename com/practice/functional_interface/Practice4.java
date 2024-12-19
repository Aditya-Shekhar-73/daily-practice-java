package practice.functional_interface;

/*
 * Practice Functional Interfaces
 * 1. Predicate
 * 2. Function
 * 3. Supplier
 * 4. Consumer
 */

import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.HashSet;
import java.util.function.Consumer;

public class Practice4 {
    public static void main(String[] args) {
        // Predicate
        Predicate<Integer> isPrime = number -> {
            if(number <= 1){
                return false;
            }

            for (int i = 2;i < number;i++){
                if (number % i == 0){
                    return false;
                }
            }
            return true;
        };

        System.out.println(isPrime.test(2));
        System.out.println(isPrime.test(4));
        System.out.println(isPrime.test(5));
        System.out.println(isPrime.test(7));

        // Function
        Function<String, String> getUpper = name -> name.toUpperCase();
        System.out.println(getUpper.apply("Flush"));

        // Consumer
        Consumer<String> print = message -> System.out.println("Hallo, " + message);
        print.accept("I am Sam!");

        // Supplier
        Supplier<HashSet<String>> getHashSet = () -> new HashSet<>();
        HashSet<String> set = getHashSet.get();
        set.add("ABC");
        set.add("DCB");

        set.forEach(System.out::println);
    }
}
