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

public class Practice14 {
    public static void main(String[] args) {
        Predicate<Integer> isOdd = num -> num % 2 != 0;
        System.out.println(isOdd.test(5));
        System.out.println(isOdd.test(4));
        System.out.println();

        Function<String, Integer> getLength = word -> word.length();
        System.out.println(getLength.apply("Hero!"));
        System.out.println();

        Supplier<ArrayList<String>> getArrayList = ArrayList::new;
        ArrayList<String> lst = getArrayList.get();

        lst.add("ABC");
        lst.add("DEC");
        lst.add("DEB");
        lst.forEach(System.out::println);
        System.out.println();

        Consumer<String> print = message -> System.out.println(message);
        print.accept("Consumer practice!");
    }
}
