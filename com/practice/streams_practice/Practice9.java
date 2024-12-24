package practice.streams_practice;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Arrays;

/*
 * Practice streams using below tools
 * 1. Filter
 * 2. Map
 * 3. Reduce
 * 4. Collectors
 */

public class Practice9 {
    public static void main(String[] args) {
        // filter and Collectors
        List<String> lst1 = Arrays.asList("ABC", "OPP", "CAT", "APPLE");

        List<String> fList = lst1.stream().filter(word -> word.startsWith("A")).collect(Collectors.toList());
        fList.forEach(System.out::println);

        // Map
        List<String> lst2 = Arrays.asList("ABC", "OPP", "CAT", "APPLE");
        lst2.stream().map(word -> word.length()).forEach(System.out::println);

        // Reduce
        List<Integer> lst3 = Arrays.asList(1, 2, 5, 4, 9);
        int result = lst3.stream().reduce(6, (a, b) -> a + b);
        System.out.println(result);
    }
}
