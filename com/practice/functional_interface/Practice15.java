package practice.functional_interface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Practice15 {
    public static void main(String[] args) {
        Predicate<String> startsWithA = word -> word.startsWith("A");
        
        Function<String, Integer> getLength = word -> word.length();

        Consumer<String> print = message -> System.out.println(message);

        Supplier<List<String>> getList = ArrayList::new;

        System.out.println(startsWithA.test("Adi"));
        System.out.println(getLength.apply("Adi"));
        print.accept("Hallu from functional interface");
        
        List<String> lst = getList.get();
        lst = Arrays.asList("ABC", "DEC", "CEB");
        lst.forEach(System.out::println);
    }
}
