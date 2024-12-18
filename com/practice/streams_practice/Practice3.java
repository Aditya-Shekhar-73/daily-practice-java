package practice.streams_practice;

import java.util.Arrays;
import java.util.List;

/*
 * Practice Streams for below operations
 * 1. Filter
 * 2. Map
 * 3. Reduce
 * 4. Collectors
 */

import java.util.stream.Collectors;

public class Practice3 {
    public static void main(String[] args) {
        
        // Filter and Collectors together
        List<String> list = Arrays.asList("Aditya", "Prastar", "Barbi", "Panda", "Atreyo", "Aman");

        List<String> filteredList = list.stream()
            .filter(name -> name.startsWith("A"))
            .collect(Collectors.toList());

        filteredList.forEach(System.out::println);

        // Map
        List<String> list2 = Arrays.asList("Aditya", "Prastar", "Barbi", "Panda", "Atreyo", "Aman");
        
        list2.stream()
            .map(name -> name.toUpperCase())
            .forEach(System.out::println);

        // Reduce
        List<Integer> numbers = Arrays.asList(1, 5, 8, 2, 4);

        int result = numbers.stream()
                            .reduce(1, (a, b) -> a * b);
        System.out.println(result);
    }
}
