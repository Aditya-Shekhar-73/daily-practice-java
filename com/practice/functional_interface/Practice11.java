package practice.functional_interface;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Practice11 {
    public static void main(String[] args) {
        Predicate<Integer> isEven = num -> num % 2 == 0;
        System.out.println(isEven.test(4));
        System.out.println(isEven.test(5));
        System.out.println();

        Function<String, Integer> getLength = sentence -> sentence.length();
        System.out.println(getLength.apply("Hallu from functional interface class."));
        System.out.println();

        Supplier<ArrayList<String>> arrayListSupplier = ArrayList::new;
        ArrayList<String> lst = arrayListSupplier.get();

        lst.add("AVP");
        lst.add("BST");
        lst.add("PriorityQueue");
        lst.add("LifoQueue");

        lst.forEach(System.out::println);
        System.out.println();

        Consumer<String> print = message -> System.out.println(message);
        print.accept("Hallu again from funtional interface class.");
    }
}
