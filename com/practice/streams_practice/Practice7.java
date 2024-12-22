package practice.streams_practice;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/*
 * Practice streams using below tools
 * 1. Filter
 * 2. Map
 * 3. Reduce
 * 4. Collectors
 */

import java.util.stream.Collectors;


public class Practice7 {
    public static void main(String[] args) {
        // Filter and Collector
        List<Integer> lst1 = Arrays.asList(
            1, 6, 7, 3, 6
        );

        List<Integer> filteredList = lst1.stream().filter(number -> number % 2 != 0).collect(Collectors.toList());
        filteredList.forEach(System.out::println);
        System.out.println("Break Point \n");

        // Map
        List<Integer> lst2 = Arrays.asList(
            1, 6, 7, 3, 6
        );
        lst2.stream().map(number -> {
            if (number % 2 != 0){
                return number * 2;
            } else {
                return 0;
            }
            }).forEach(System.out::println);
        System.out.println("Break Point \n");

        // Reduce
        List<Integer> lst3 = Arrays.asList(
            1, 6, 7, 3, 6
        );
        int result = lst3.stream().reduce(1, (a, b) -> a * b);
        System.out.println("Result from reduce function: " + result);
        System.out.println("Break Point \n");


        // Collectors GroupingBy
        List<String> lst4 = Arrays.asList(
            "Akash", "Barbie", "Aditya", "Prastar", "Aniket", "Harshit", "Adwi", "Mannu"
        );

        Map<Character, List<String>> map = lst4.stream().collect(Collectors.groupingBy(word -> word.charAt(0)));
        map.forEach((key, value) -> System.out.println(key + ": " + value));
        
    }
}
