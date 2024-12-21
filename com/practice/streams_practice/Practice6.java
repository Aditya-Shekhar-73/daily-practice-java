package practice.streams_practice;

/*
 * Practice streams using below tools
 * 1. Filter
 * 2. Map
 * 3. Reduce
 * 4. Collectors
 */

import java.util.List;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Practice6 {
    public static void main(String[] args) {
        // Filter and Collectors to collect it
        List<Integer> list1 = Arrays.asList(1, 8, 9, 4, 6);

        List<Integer> filteredList = list1.stream()
                                    .filter(num -> num % 2 == 0)
                                    .collect(Collectors.toList());
        filteredList.forEach(System.out::println);
        System.out.println();

        // Map
        List<Integer> list2 = Arrays.asList(
            1, 5, 7, 3, 5
        );

        list2.stream()
        .map(num -> num * 4)
        .forEach(System.out::println);
        System.out.println();

        // Reduce
        List<Integer> list3 = Arrays.asList(
            1, 5, 7, 3, 5
        );
        int result = list3.stream()
                     .reduce(0, Integer::sum);
        System.out.println(result);

        // Grouping by
        List<String> list4 = Arrays.asList(
            "Akash", "Barbie", "Aditya", "Prastar", "Aniket", "Harshit", "Adwi", "Mannu"
        );

        Map<Character, List<String>> map = list4.stream().collect(Collectors.groupingBy(word -> word.charAt(0)));
        map.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
