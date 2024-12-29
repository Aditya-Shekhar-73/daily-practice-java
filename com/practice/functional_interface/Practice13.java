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

public class Practice13 {
    public static void main(String[] args) {
        Predicate<String> isFirstLetterLower = word -> {
            if (word.charAt(0) == word.toLowerCase().charAt(0)){
                return true;
            }
            return false;
        };

        System.out.println(isFirstLetterLower.test("Abc"));
        System.out.println(isFirstLetterLower.test("abc"));

        Function<Integer, Integer> getDouble = num -> num * 2;
        System.out.println(getDouble.apply(4));
        
        Consumer<String> print = message -> System.out.println(message);
        print.accept("Hallu from consumer function interface!");

        Supplier<ArrayList<Integer>> getArrayList = ArrayList::new;
        ArrayList<Integer> lst = getArrayList.get();

        lst.add(1);
        lst.add(2);
        lst.add(3);

        lst.forEach(System.out::println);
    }
}
