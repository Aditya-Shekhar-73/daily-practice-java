package practice.streams_practice;

import java.util.Arrays;
import java.util.List;

/*
 * Practice streams using below tools
 * 1. Filter
 * 2. Map
 * 3. Reduce
 * 4. Collectors
 */

import java.util.stream.Collectors;

public class Practice5 {
    public static void main(String[] args) {
        // Filter and Collectors
        List<Integer> lst = Arrays.asList(
            1, 5, 8, 3, -9, -6
        );

        List<Integer> filteredList = lst.stream()
                                        .filter(num -> num > 0)
                                        .collect(Collectors.toList());
        filteredList.forEach(System.out::println);

        System.out.println("---");

        // Map
        List<Integer> lst2 = Arrays.asList(
            4, 8, -9, -2, 2, -6
        );
        lst2.stream()
        .map(num -> num * 2)
        .forEach(System.out::println);

        // Reduce
        List<Integer> lst3 = Arrays.asList(
            5, 8, 6, 2
        );

        System.out.println("---");
        int result = lst3.stream()
                        .reduce(1, (a, b) -> a * b);
        System.out.println(result);
    }
}
