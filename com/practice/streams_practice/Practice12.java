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

public class Practice12 {
    public static void main(String[] args) {
        // Filter and Collectors
        List<Integer> lst1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> fList = lst1.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());
        fList.forEach(System.out::println);

        // Map
        List<String> lst2 = Arrays.asList("aditya","shekhar", "kumar", "satyajeet");
        lst2.stream().map(String::toUpperCase).forEach(System.out::println);

        // Reduce
        List<Integer> lst3 = Arrays.asList(1, 2, 3, 4, 5, 6);
        int result = lst3.stream().reduce(1, (a, b) -> a ^ b);
        System.out.println(result);
    }
}
