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

class PracticePredicate16 {
    public static void test(){
        Predicate<Integer> isGreaterThan5 = num -> num > 5;
        System.out.println(isGreaterThan5.test(6));
        System.out.println(isGreaterThan5.test(4));
    }
}

class PracticeFunction16 {
    public static void test(){
        Function<Integer, Integer> getDouble = num -> num * 2;
        System.out.println(getDouble.apply(3));
    }
}

class PracticeSupplier16 {
    public static void test(){
        Supplier<ArrayList<String>> getASupplier = ArrayList::new;

        ArrayList<String> lst = getASupplier.get();
        lst.add("PNG");
        lst.add("JPG");
        lst.add("JPEG");

        lst.forEach(System.out::println);
    }
}

class PracticeConsumer16 {
    public static void test() {
        Consumer<String> print = message -> System.out.println(message);
        print.accept("Hallu from consumer functional interface!");
    }
}

public class Practice16 {
    public static void main(String[] args) {
        PracticePredicate16.test();
        PracticeFunction16.test();
        PracticeSupplier16.test();
        PracticeConsumer16.test();
    }
}
