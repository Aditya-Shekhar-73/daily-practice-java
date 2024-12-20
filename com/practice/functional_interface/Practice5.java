package practice.functional_interface;

import java.util.ArrayList;
import java.util.List;

/*
 * Practice Functional Interfaces
 * 1. Predicate
 * 2. Function
 * 3. Supplier
 * 4. Consumer
 */

import java.util.function.*;

public class Practice5 {
    public static void main(String[] args) {
        // Predicate
        Predicate<Integer> isPositive = number -> number > 0;
        System.out.println(isPositive.test(3));
        System.out.println(isPositive.test(-3));
        
        // Function
        Function<Integer, String> convertToString = num -> num.toString();
        System.out.println(convertToString.apply(8));

        // Supplier
        Supplier<List<Integer>> getList = () -> new ArrayList<>();
        List<Integer> lst = getList.get();

        lst.add(1);
        lst.add(2);
        lst.add(3);
        
        lst.forEach(val -> System.out.println(val));

        // Consumer
        Consumer<Integer> print = num -> System.out.println(num * 9);
        print.accept(78);
    }
}
