package practice.functional_interface;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Practice9 {
    public static void main(String[] args) {
        // Predicate
        Predicate<Integer> isEven = number -> number % 2 == 0;
        System.out.println(isEven.test(8));

        // Function
        Function<Integer, String> toString = number -> number.toString();
        System.out.println(toString.apply(3));

        // Consumer
        Consumer<String> print = messgae -> System.out.println(messgae);
        print.accept("My name is Gabbar!");

        // Suppler
        Supplier<ArrayList<String>> getList = ArrayList::new;
        ArrayList<String> list = getList.get();
        list.add("ABC");
        list.add("DEC");

        list.forEach(System.out::println);
    }
}
