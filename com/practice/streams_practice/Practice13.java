package practice.streams_practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Practice streams using below tools
 * 1. Filter
 * 2. Map
 * 3. Reduce
 * 4. Collectors
 */

public class Practice13 {
    public static void main(String[] args) {
        // Filter and COllectors
        List<Integer> lst1 = Arrays.asList(
            1, 2, 3, 4, 5, 6, 7
        );

        List<Integer> fList = lst1.stream().filter(num -> num % 5 == 0).collect(Collectors.toList());
        fList.forEach(System.out::println);
        System.out.println();

        // Map and Reduce
        List<Integer> lst2 = Arrays.asList(
            1, 2, 3, 4, 5, 6, 7
        );
        lst2.stream().map(num -> num * 2).forEach(System.out::println);
        System.out.println();

        int result = lst2.stream().reduce(0, (a, b) -> a + b);
        System.out.println(result);
    }
}
