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

public class Practice11 {
    public static void main(String[] args) {
        // Filter and Collectors
        List<Integer> lst = Arrays.asList(1, 5, 7, 8, 9, 10);
        List<Integer> fList = lst.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());

        fList.forEach(System.out::println);
        System.out.println();

        // Map
        List<Integer> lst1 = Arrays.asList(1, 5, 7, 8, 9, 10);
        lst1.stream().map(num -> num * 3).forEach(System.out::println);
        System.out.println();

        // Reduce
        List<Integer> lst2 = Arrays.asList(1, 5, 7, 8, 9, 10);
        int result = lst2.stream().reduce(0, (a, b) -> a + b);
        System.out.println(result);
    }
}
