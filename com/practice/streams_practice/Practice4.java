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

public class Practice4 {
    public static void main(String[] args) {
        // Filter and Collector together
        List<String> list = Arrays.asList(
            "ABC", "DCAA", "ACB", "CBAA", "AC"
        );

        List<String> filteredList = list.stream().filter(name -> name.length() > 3).collect(
            Collectors.toList()
        );

        filteredList.forEach(System.out::println);
        System.out.println();

        // Map
        List<String> list2 = Arrays.asList(
            "ABC", "DCAA", "ACB", "CBAA", "AC"
        );

        list2.stream()
        .map(String::toLowerCase)
        .forEach(System.out::println);
        System.out.println();

        // Reduce
        List<Integer> numbers = Arrays.asList(1, 8, 6, 2, 6);

        int result = numbers.stream()
                     .reduce(9, (a, b) -> (a + b)*2);
        System.out.println(result);
    }
}
