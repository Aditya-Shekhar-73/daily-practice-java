package practice.streams_practice;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/*
 * Practice streams using below tools
 * 1. Filter
 * 2. Map
 * 3. Reduce
 * 4. Collectors
 */

public class Practice16 {
    public static void main(String[] args) {
        // Filter and Collectors and Optional
        List<Integer> lst1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        List<Integer> fList = lst1.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());
        fList.forEach(System.out::println);
        System.out.println();

        Optional<Integer> result1 = fList.stream().filter(num -> num % 2 == 0).findFirst();
        result1.ifPresent(System.out::println);
        System.out.println();

        // Map and Reduce
        List<Integer> lst2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        lst2.stream().map(num -> num * 2).forEach(System.out::println);
        System.out.println();

        List<Integer> lst3 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        int result2 = lst3.stream().reduce(1, (a, b) -> a + b);
        System.out.println(result2);
        System.out.println();
    }
}
